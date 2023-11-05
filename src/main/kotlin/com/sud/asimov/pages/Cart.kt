package com.sud.asimov.pages

import com.sud.asimov.api.cartproduct.CartProductRepository
import com.sud.asimov.pages.dto.LoginDTO
import com.sud.asimov.pages.dto.ProductAddDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class Cart {
    @Autowired
    lateinit var repository : CartProductRepository;
    @GetMapping("/cart/{id}")
    @Transactional
    fun cartNotConnected(@PathVariable("id") id: Long, model : Model) : String {
        model.addAttribute("items", repository.findAllByUserId(id))
        return "cart"
    }

}