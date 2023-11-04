package com.sud.asimov.pages

import com.sud.asimov.*
import com.sud.asimov.api.cartproduct.CartProductRepository
import com.sud.asimov.pages.dto.ProductAddDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class Admin {
    @Autowired
    lateinit var categoryRepository : CategoryRepository;

    @Autowired
    lateinit var userRepository : UserRepository;

    @Autowired
    lateinit var productsRepository : ProductRepository;

    @Autowired
    lateinit var cartProductsRepository : CartProductRepository;
    @GetMapping("/admin")
    fun admin(model : Model) : String {
        // Check creditials
        // return 403

        model.addAttribute("users", userRepository.findAll())
        model.addAttribute("products", productsRepository.findAll())
        model.addAttribute("categories", categoryRepository.findAll())
        return "administration"
    }

    @GetMapping("/admin/fragment/user")
    fun showUserPart(model : Model) : String {
        model.addAttribute("users", userRepository.findAll())
        return "administration :: #admin-users-list"
    }

    @GetMapping("/admin/fragment/product")
    fun showProductPart(model : Model) : String {
        model.addAttribute("products", productsRepository.findAll())
        model.addAttribute("categories", categoryRepository.findAll())
        return "administration :: #admin-products-list"
    }

    @GetMapping("/admin/fragment/categories")
    fun showCategoriesPart(model : Model) : String {
        model.addAttribute("categories", categoryRepository.findAll())
        return "administration :: #admin-categories-list"
    }

    @PostMapping("/admin/delete/user")
    @Transactional
    fun userDeleteSubmit(@RequestBody userId : Long, model: Model): ResponseEntity<String> {
        userRepository.deleteById(userId)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Utilisateur supprimé")
    }

    @PostMapping("/admin/delete/product")
    @Transactional
    fun productDeleteSubmit(@RequestBody productId : Long, model: Model): ResponseEntity<String> {
        productsRepository.deleteById(productId)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Produit supprimé")
    }

    @PostMapping("/admin/delete/category")
    @Transactional
    fun categoryDeleteSubmit(@RequestBody categoryName: String, model: Model): ResponseEntity<String> {
        val name = categoryName.subSequence(1 until categoryName.length-1).toString()
        val lp = productsRepository.findByCategory(Category(name))
        lp.forEach(action = {
            it.id?.let { it1 ->
                cartProductsRepository.deleteCartProductByProductId(it1)
                productsRepository.deleteById(it1) }
        })
        categoryRepository.deleteById(name)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Categorie supprimé")
    }

    @PostMapping("/admin/add/product")
    @Transactional
    fun productAddSubmit(@RequestBody product : ProductAddDTO, model: Model): ResponseEntity<String> {
        productsRepository.save(Product(null,
                product.name,
                Category(product.category),
                product.price,
                product.description,
                product.stock,
                product.reference,
                null)) // TODO: Change by file
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Produit ajouté")
    }
}