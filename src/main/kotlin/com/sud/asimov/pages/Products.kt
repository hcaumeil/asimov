package com.sud.asimov.pages

import com.sud.asimov.Category
import com.sud.asimov.Product
import com.sud.asimov.ProductRepository
import com.sud.asimov.pages.dto.CategoryProductCommandDTO
import com.sud.asimov.pages.dto.ContactDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
class Products {
    @Autowired
    lateinit var repository : ProductRepository
    @GetMapping("/products")
    @Transactional
    fun products(@RequestParam categoryName : String, model : Model): String {
        // Get all products from category
        val products : List<Product> = repository.findByCategory(Category(categoryName))

        val form = CategoryProductCommandDTO(categoryName, MutableList(products.indices.last + 1) {0})
        model.addAttribute("categoryProductCommandDTO", form)

        // Set the model with data
        model.addAttribute("category", categoryName)
        model.addAttribute("products", products)
        return "products"
    }

    @PostMapping("/products/p")
    @Transactional
    fun categoryProductCommandSubmit(@RequestBody categoryProductCommandData : CategoryProductCommandDTO, model: Model): ResponseEntity<String> {
        // Traitement
        // Erreur inattendu ?
        //model.addAttribute("message", "Erreur : Un problème serveur est survenu")

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Commande pris en compte")
    }
}
