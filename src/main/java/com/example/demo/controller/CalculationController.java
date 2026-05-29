package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {

    private static final double GRAVITY = 9.8;

    @PostMapping("/calculation")
    public String calculation(
            @RequestParam double altitude,
            @RequestParam double speed,
            @RequestParam double wind,
            Model model) {

        double fallTime = Math.sqrt(2 * altitude / GRAVITY);
        int range = (int) ((speed + wind) * fallTime);

        model.addAttribute("R", range);
        return "result";
    }

    @GetMapping("/")
    public String input() {
        return "input";
    }
}
