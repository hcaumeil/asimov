package com.sud.asimov;

// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Ping {
    @RequestMapping("/api/ping")
	fun ping(): String {
        return "PONG !"
	}
}