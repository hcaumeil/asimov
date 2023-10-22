package com.sud.asimov.pages

import com.sud.asimov.Category
import com.sud.asimov.Product
import com.sud.asimov.ProductRepository
import com.sud.asimov.pages.dto.CategoryProductCommandDTO
import com.sud.asimov.pages.dto.ContactDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class Products {
    @Autowired
    lateinit var repository : ProductRepository
    @GetMapping("/products")
    @Transactional
    fun products(@RequestParam categoryName : String, model : Model): String {
        // Get all products from category
        val products : List<Product> = repository.findByCategory(Category(categoryName))

        val form = CategoryProductCommandDTO(MutableList(products.indices.last + 1) {0})
        model.addAttribute("categoryProductCommandDTO", form)

        // Set the model with data
        model.addAttribute("category", categoryName)
        model.addAttribute("products", products)
        return "products"
    }

    @PostMapping("/products")
    @Transactional
    fun categoryProductCommandSubmit(@RequestParam categoryName : String, @ModelAttribute categoryProductCommandData : CategoryProductCommandDTO, model: Model): String {
        // Traitement
        // Erreur inattendu ?
        //model.addAttribute("message", "Erreur : Un problème serveur est survenu")

        // Get all products from category
        val products : List<Product> = repository.findByCategory(Category(categoryName))

        val form = CategoryProductCommandDTO(MutableList(products.indices.last + 1) {0})
        model.addAttribute("categoryProductCommandDTO", form)
        model.addAttribute("category", categoryName)
        model.addAttribute("message", "Votre commande a bien été pris en compte")
        return "products"
    }
}
