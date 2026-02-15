package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculation{
    double g = 9.8;
    @PostMapping("/calculation")
    public String calculation(
        @RequestParam double altitude,
        @RequestParam double speed,
        @RequestParam double wind,
        Model model) {
            double t = Math.sqrt(2*altitude / g);
            double r = ((speed+wind) *t);
            int R = (int)r;
            model.addAttribute("R" , R);
            return "R";
        }
}
