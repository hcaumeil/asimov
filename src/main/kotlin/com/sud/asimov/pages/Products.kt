package com.sud.asimov.pages

import com.sud.asimov.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class Products {
    @Autowired
    lateinit var repository : CategoryRepository
    @GetMapping("/products")
    fun products(@RequestParam categoryName : String, model : Model): String {
        model.addAttribute("cat", categoryName)
        return "products"
    }
}
