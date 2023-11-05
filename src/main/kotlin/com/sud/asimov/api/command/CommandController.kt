package com.sud.asimov;

// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.sud.asimov.Command;


@RestController
@RequestMapping("/api/command")
public class CommandController {

    @Autowired
    lateinit var repository : CommandRepository;

    @GetMapping()
	fun get(): List<Command> {
        return repository.findAll();
	}


    @PostMapping()
    fun post(@RequestBody user: Command): Command {    
        return repository.save(user);
    }
}
