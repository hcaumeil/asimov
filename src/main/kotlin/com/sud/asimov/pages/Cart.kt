package com.sud.asimov.pages

import com.sud.asimov.pages.dto.LoginDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Cart {
    @GetMapping("/cart")
    fun categories(model : Model) : String {
        return "cart"
    }
}