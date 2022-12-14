package com.example.html_warmup_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/ex2")
    public String ex2() {
        return "ex2";
    }

    @GetMapping("/hit")
    public String hit() {
        return "hit";
    }

    @GetMapping("/doc")
    public String doc() {
        return "doc";
    }

}
