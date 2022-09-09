package com.example.myfirstwebsite.controller;

import com.example.myfirstwebsite.service.CurrentDay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Hello Dat22v1";
    }

    @GetMapping("/message")
    public String Message(@RequestParam String name) {
        return String.format("Hello %s! hows it going dude", name);
    }

    @GetMapping("/echo")
    public String Echo(@RequestParam String input) {
        return input;
    }

    @GetMapping("/erdetfredag")
    public String ErDetFredag() {
        return CurrentDay.isFriday();
    }


}
