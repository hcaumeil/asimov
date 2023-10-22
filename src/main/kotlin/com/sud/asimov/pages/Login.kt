package com.sud.asimov.pages

import com.sud.asimov.User
import com.sud.asimov.pages.dto.LoginDTO
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping

@Controller
class Login {
    @GetMapping("/login")
    fun categories(model : Model) : String {
        model.addAttribute("loginDTO", LoginDTO())
        return "login"
    }

    @PostMapping("/login")
    fun greetingSubmit(@ModelAttribute loginData : LoginDTO, model: Model): String {
        // verifie email / password
        if (loginData.email == "a") { // Debug
            model.addAttribute("error", "Erreur : Email ou mot de passe incorrect")
            model.addAttribute("loginDTO", LoginDTO()) // debug
            // Return error
            return "login"
        }
        // Return index
        return "index"
    }
}