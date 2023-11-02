package com.sud.asimov.pages

import com.sud.asimov.pages.dto.ContactDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Errors {
    @GetMapping("/404")
    fun error404(model : Model) : String {
        return "404"
    }
    @GetMapping("/403")
    fun error403(model : Model) : String {
        return "403"
    }
}