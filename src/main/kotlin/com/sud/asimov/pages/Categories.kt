package com.sud.asimov.pages

import com.sud.asimov.Category
import com.sud.asimov.CategoryController
import com.sud.asimov.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class Categories {
    @Autowired
    lateinit var repository : CategoryRepository;
    @GetMapping("/categories")
    fun categories(model : Model) : String {
        model.addAttribute("categories", repository.findAll())
        return "categories"
    }
}