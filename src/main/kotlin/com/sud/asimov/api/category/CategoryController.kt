package com.sud.asimov;

// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @GetMapping()
	fun get(): List<Category> {
        var objects : List<Category> = listOf();
        objects += Category("aa");
        return objects;
	}
}