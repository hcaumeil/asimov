package com.sud.asimov.pages

import com.sud.asimov.Category
import com.sud.asimov.Product
import com.sud.asimov.ProductRepository
import com.sud.asimov.UserRepository
import com.sud.asimov.api.cartproduct.CartProductRepository
import com.sud.asimov.api.entities.CartProduct
import com.sud.asimov.pages.dto.ProductCommandDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.getOrNull

@Controller
class Products {
    @Autowired
    lateinit var userRepository : UserRepository;

    @Autowired
    lateinit var productsRepository : ProductRepository;
    @Autowired
    lateinit var cartProductRepository : CartProductRepository
    @GetMapping("/products")
    @Transactional
    fun products(@RequestParam categoryName : String, model : Model): String {
        // Get all products from category
        val products : List<Product> = productsRepository.findByCategory(Category(categoryName))
        // Set the model with data
        model.addAttribute("category", categoryName)
        model.addAttribute("products", products)
        return "products"
    }

    @PostMapping("/products/add-cart")
    @Transactional
    fun productCommandSubmit(@RequestBody productCommandData : ProductCommandDTO, model: Model): ResponseEntity<String> {
        val u = userRepository.findById(productCommandData.userId)
        if (u.isEmpty) return ResponseEntity.badRequest().body("User not found")

        val p = productsRepository.findById(productCommandData.productId)
        if (p.isEmpty) return ResponseEntity.badRequest().body("Product not found")

        val existing = cartProductRepository.findByUserIdAndProductId(u.get().id!!, p.get().id!!)

        if (existing == null) cartProductRepository.save(CartProduct(null, u.get(), p.get(), productCommandData.quantity))
        else {
            if (existing.quantity + productCommandData.quantity <= existing.product.stock)
                existing.quantity += productCommandData.quantity
            else
                existing.quantity = existing.product.stock.toLong()
            cartProductRepository.save(existing)
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Commande pris en compte")
    }
}
