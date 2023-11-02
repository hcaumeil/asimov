package com.sud.asimov.pages

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Admin {
    @GetMapping("/admin")
    fun admin(model : Model) : String {
        // Check creditials
        // return 403

        return "administration"
    }
}