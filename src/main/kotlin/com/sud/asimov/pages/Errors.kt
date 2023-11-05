package com.sud.asimov.pages

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Errors {
    @GetMapping("/404")
    fun error404(model : Model) : String {
        return "error"
    }
    @GetMapping("/403")
    fun error403(model : Model) : String {
        return "403"
    }
}