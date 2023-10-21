package com.sud.asimov.pages

import com.sud.asimov.pages.dto.ContactDTO
import com.sud.asimov.pages.dto.LoginDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class Contact {
    @GetMapping("/contact")
    fun categories(model : Model) : String {
        model.addAttribute("contactDTO", ContactDTO())
        return "contact"
    }

    @PostMapping("/contact")
    fun greetingSubmit(@ModelAttribute contactData : ContactDTO, model: Model): String {
        // Traitement
        // Erreur inattendu ?
        //model.addAttribute("message", "Erreur : Un problème serveur est survenu")

        model.addAttribute("contactDTO", ContactDTO())
        model.addAttribute("message", "Votre message a bien été envoyé")
        return "contact"
    }
}