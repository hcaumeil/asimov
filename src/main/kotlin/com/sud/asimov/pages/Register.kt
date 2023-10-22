package com.sud.asimov.pages

import com.sud.asimov.User
import com.sud.asimov.UserRepository
import com.sud.asimov.pages.dto.LoginDTO
import com.sud.asimov.pages.dto.RegisterDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class Register {
    @Autowired
    lateinit var repository : UserRepository;
    @GetMapping("/register")
    fun categories(model : Model) : String {
        model.addAttribute("registerDTO", RegisterDTO())
        return "register"
    }

    @PostMapping("/register")
    fun greetingSubmit(@ModelAttribute registerData : RegisterDTO, model: Model): String {
        // verifie email
        if (registerData.email == "a") { // Debug TODO
            model.addAttribute("error", "Erreur : Email déjà existant")
            model.addAttribute("loginDTO", LoginDTO()) // debug
            // Return error
            return "register"
        }

        if (registerData.password1 != registerData.password2) {
            model.addAttribute("error", "Erreur : Mot de passe non identique")
            model.addAttribute("registerDTO", RegisterDTO()) // debug
            // Return error
            return "register"
        }

        // Inscription en BD
        repository.save(User(null, registerData.name, registerData.family_name, registerData.email, registerData.password1))

        model.addAttribute("message", "Vous êtes bien inscrit")
        return "register"
    }
}