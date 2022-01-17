package org.example.NC.controller;

import org.example.NC.domain.Human;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
//@RequestMapping("/u")
@PreAuthorize("hasAuthority('USER')")
public class ClientController {
    public String chooseTariff(@RequestParam String username,
                               @RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String patronymic,
                               @RequestParam Map<String, String> form,
                               @RequestParam("userId") Human user,
                               Model model){
        //model.addAttribute("users", userRepo.findAll());

        return "";
    }
    @GetMapping("/personalArea")
    public String main1(Map<String, Object> model) {
        model.put("some", "hello!");
        return "personalArea";
    }
}
