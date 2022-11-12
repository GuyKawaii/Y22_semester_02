package com.example.thymeleafopg.controller;

import com.example.thymeleafopg.repository.ArmyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArmyController {

    ArmyRepository armyRepository = new ArmyRepository();

    @GetMapping("/")
    public String index(Model model) {

        // array from dbms
        List<String> soldiers = armyRepository.getSoldiers();

        // dynamic content
        model.addAttribute("name", "Malik");
        model.addAttribute("age", "THATS ILLIGAL BRO");
        model.addAttribute("solders", soldiers);


        return "index";
    }
}
