package com.sud.asimov;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    lateinit var repository : CategoryRepository;

    @GetMapping()
	fun get(): List<Category> {
        return repository.findAll();
	}

    @PostMapping()
    fun post(@RequestBody category: Category): Category {    
        return repository.save(category);
    }
}