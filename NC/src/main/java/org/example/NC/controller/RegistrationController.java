package org.example.NC.controller;

import org.example.NC.domain.Human;
import org.example.NC.domain.Role;
import org.example.NC.repos.UserRepo;
import org.example.NC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid Human user, Model model) {
        Human userFromDb = userRepo.findByUsername(user.getUsername());

       /* if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }*/
        if (!userService.addUser(user)) {
            //model.addAttribute("usernameError", "User exists!");
            return "registration";
        }
        /*user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
*/
        return "redirect:/login";
    }
}