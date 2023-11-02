package com.sud.asimov.pages

import com.sud.asimov.CategoryRepository
import com.sud.asimov.ProductRepository
import com.sud.asimov.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Admin {
    @Autowired
    lateinit var categoryRepository : CategoryRepository;

    @Autowired
    lateinit var userRepository : UserRepository;

    @Autowired
    lateinit var productsRepository : ProductRepository;
    @GetMapping("/admin")
    fun admin(model : Model) : String {
        // Check creditials
        // return 403

        model.addAttribute("users", userRepository.findAll())
        model.addAttribute("products", productsRepository.findAll())
        model.addAttribute("categories", categoryRepository.findAll())
        return "administration"
    }
}