package com.sud.asimov.pages

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Categories {
    @GetMapping("/categories")
    fun categories(model : Model) : String = "categories"
}