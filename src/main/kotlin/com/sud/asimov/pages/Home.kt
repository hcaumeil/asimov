package com.sud.asimov;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
class HelloController {    
    @GetMapping("/")
    fun home(model : Model) : String = "index"
}