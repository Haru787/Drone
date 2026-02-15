package com.example.demo;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;

/*
@Controller
public class Fortune {
    
    @RequestMapping("/fortune")
    public String start() {
        double fn = Math.random();
        if(fn >= 0.7) {
            return "greatFortune.html";
        }else if (fn >= 0.4) {
            return "middleFortune.html";
        }else if(fn >= 0.1) {
            return "smallFortune.html";
        }else {
            return "misFortune.html";
        }
    }
}
*/

@RestController
public class FortuneApi {

    @GetMapping("/api/fortune")
    public String fortune() {
        double fn = Math.random();
        if (fn >= 0.7) return "大吉";
        if (fn >= 0.4) return "中吉";
        if (fn >= 0.1) return "小吉";
        return "凶";
    }
}