package org.example.NC.controller;

import org.example.NC.domain.Client;
import org.example.NC.domain.Role;
import org.example.NC.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Client client, Map<String, Object> model) {
        Client clientFromDb = userRepo.findByUsername(client.getUsername());

        if (clientFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        client.setActive(true);
        client.setRoles(Collections.singleton(Role.USER));
        userRepo.save(client);

        return "redirect:/login";
    }
}