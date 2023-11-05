package com.sud.asimov;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginBody (
    var email : String,
    var password : String,
) {
}

public class UserDetails(
    public val id: Long,
    public var name : String,
    public var family_name : String,
    public var email : String,
        var role : String
) {}

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    lateinit var repository : UserRepository;

    @PostMapping()
    fun post(@RequestBody body : LoginBody): UserDetails? {    
        var user : User? = null;

        for (u in repository.findAll()) {
            if (u.email == body.email && u.password == body.password) {
                user = u;
            }
        }

        if (user == null) {
            return null;
        }
        
        return user_to_details(user);
    }

    fun user_to_details(u : User) : UserDetails {
        return UserDetails(u.id!!, u.name, u.family_name, u.email, u.role);
    }
}
