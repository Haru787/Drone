package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hello")
public class WorldController {
    
    @GetMapping("/world")
    public String world() {
        return "World Spring Boot!";
    }
}