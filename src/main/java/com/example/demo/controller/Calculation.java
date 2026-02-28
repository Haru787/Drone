package com.example.demo.controller;

import com.example.demo.entity.FallHistory;
import com.example.demo.repository.FallHistoryRepository;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculation{

    private final FallHistoryRepository repository;

     public Calculation(FallHistoryRepository repository) {
        this.repository = repository;
    }

    double g = 9.8;
    @PostMapping("/calculation")
    public String calculation(
        @RequestParam double altitude,
        @RequestParam double speed,
        @RequestParam double wind,
        Model model) {

            System.out.println("### calculation controller called ###");

            double t = Math.sqrt(2*altitude / g);
            double r = ((speed+wind) *t);
            int R = (int)r;
            
            FallHistory history =
            new FallHistory(altitude, speed, wind, R);

            System.out.println("### before save ###");

        repository.save(history);

        System.out.println("### after save ###");

            model.addAttribute("R" , R);
            return "R";
        }
        @GetMapping("/")
        public String input(Model model) {

            List<FallHistory> histories =
                repository.findTop25ByOrderByCreatedAtDesc();

            model.addAttribute("histories", histories);
            return "input";
}
}
