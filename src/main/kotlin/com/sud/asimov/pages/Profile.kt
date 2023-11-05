package com.sud.asimov.pages

import com.sud.asimov.CommandRepository
import com.sud.asimov.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class Profile {
    @Autowired
    lateinit var userRepository : UserRepository;
    @Autowired
    lateinit var commandRepository : CommandRepository;
    @GetMapping("/profile/{id}")
    @Transactional
    fun profile(@PathVariable("id") id: Long, model : Model) : String {
        model.addAttribute("user", userRepository.findById(id).get())
        model.addAttribute("commands", commandRepository.findByUserId(id))
        return "profile"
    }
}