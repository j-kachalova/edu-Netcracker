package org.example.NC.controller;

import org.example.NC.domain.Tariff;
import org.example.NC.domain.TariffСategory;
import org.example.NC.repos.UserRepo;
import org.example.NC.repos.TariffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        Stream<Tariff> tariffStream = StreamSupport.stream(tariffRepo.findAll().spliterator(), false);
        //Map<Tariff, TariffСategory> tariffs = tariffRepo.findAll();
        Map<TariffСategory, List<Tariff>> tariffByCategory = tariffStream.collect(
                Collectors.groupingBy(Tariff::getCategory));

        for(Map.Entry<TariffСategory, List<Tariff>> item : tariffByCategory.entrySet()){

            System.out.println(item.getKey().getName());
            for(Tariff tariff : item.getValue()){

                System.out.println(tariff.getName());
            }
            System.out.println();
        }
        model.put("tariff", tariffByCategory.entrySet());
        return "tariff2";
    }
}