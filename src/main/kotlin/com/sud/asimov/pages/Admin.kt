package com.sud.asimov.pages

import com.sud.asimov.CategoryRepository
import com.sud.asimov.ProductRepository
import com.sud.asimov.UserRepository
import com.sud.asimov.pages.dto.CategoryProductCommandDTO
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
        return "administration :: #admin-products-list"
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
}