package org.example.NC.controller;

import org.example.NC.domain.Tariff;
import org.example.NC.repos.UserRepo;
import org.example.NC.repos.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepo clientRepo;
    @Autowired
    private TariffRepo tariffRepo;
    /*@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/
    /*@GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "hello!");
        return "main";
    }*/
    @GetMapping
    public String tariff(Map<String, Object> model) {
        Iterable<Tariff> tariffs = tariffRepo.findAll();

        model.put("tariff", tariffs);
        return "tariff";
    }
}