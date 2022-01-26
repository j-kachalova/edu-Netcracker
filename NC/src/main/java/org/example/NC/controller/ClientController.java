package org.example.NC.controller;

import com.sun.source.doctree.SeeTree;
import org.example.NC.domain.Human;
import org.example.NC.domain.NumberSIM;
import org.example.NC.domain.Role;
import org.example.NC.repos.NumberRepo;
import org.example.NC.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Controller
//@RequestMapping("/u")
@PreAuthorize("hasAuthority('USER')")
public class ClientController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private NumberRepo numberRepo;
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
    public String personalArea(Map<String, Object> model) {
        //model.put("human", "hello!");
        return "personalArea";
    }

    @PostMapping("/sim1")
    public String chooseKindSIM(Human user, Map<String, Object> model) {
        //model.put("human", userRepo.findByUsername(user.getUsername()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "/sim2";
    }
    @GetMapping("/purchase")
    public String buy(Human user, Map<String, Object> model) {
        //Human userFromDb = userRepo.findByUsername(user.getUsername());
        Human userFromDb = (Human) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if (userFromDb != null) {
            model.put("human", userFromDb);
            return "purchase";
        }
        /*List<NumberSIM> number = numberRepo.findAll().stream().filter(x-> x.isUsed()==false).collect(Collectors.toList());
        System.out.println(number);*/
        //Iterable<NumberSIM> num;
        Stream<NumberSIM> number = StreamSupport.stream(numberRepo.findAll().spliterator(), false)
                .filter(x -> !x.isUsed());

        System.out.println(number.toString());
        model.put("numbers", number);
        return "purchase1";
    }
    @PostMapping("/sim")
    public String chooseNum(Human user, Map<String, Object> model) {
        //model.put("human", userRepo.findByUsername(user.getUsername()));
        return "/sim2";
    }
}
