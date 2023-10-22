package com.sud.asimov.pages

import com.sud.asimov.Category
import com.sud.asimov.CategoryRepository
import com.sud.asimov.Product
import com.sud.asimov.ProductRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
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

        // Set the model with data
        model.addAttribute("category", categoryName)
        model.addAttribute("products", products)
        return "products"
    }
}
