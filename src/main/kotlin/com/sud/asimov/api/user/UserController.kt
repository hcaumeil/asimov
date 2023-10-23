package com.sud.asimov;

// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    lateinit var repository : UserRepository;

    @GetMapping()
	fun get(): List<User> {
        return repository.findAll();
	}


    @PostMapping()
    fun post(@RequestBody user: User): User {    
        return repository.save(user);
    }
}