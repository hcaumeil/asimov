package com.sud.asimov;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.sud.asimov.Command;
import org.springframework.http.ResponseEntity;

public class CommandInfo (
     id : Long,
     user: User,
) {}


@RestController
@RequestMapping("/api/command")
public class CommandController {

    @Autowired
    lateinit var repository : CommandRepository;

    @GetMapping()
	fun get(): List<CommandInfo> {
        var cmds = repository.findAll();
        var res : List<CommandInfo> = cmds.map { CommandInfo(it.id!!, it.user) } as List<CommandInfo>

        return res
	}


    @PostMapping()
    fun post(@RequestBody user: Command): Command {    
        return repository.save(user);
    }
}
