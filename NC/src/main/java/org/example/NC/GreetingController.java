package org.example.NC;

import org.example.NC.domain.Tariff;
import org.example.NC.domain.TariffСategory;
import org.example.NC.repos.ClientRepo;
import org.example.NC.repos.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private TariffRepo tariffRepo;
    /*@GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/
    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "hello!");
        return "main";
    }
    @GetMapping("/tariff")
    public String tariff(Map<String, Object> model) {
        Iterable<Tariff> tariffs = tariffRepo.findAll();

        model.put("tariff", tariffs);
        return "tariff";
    }
}