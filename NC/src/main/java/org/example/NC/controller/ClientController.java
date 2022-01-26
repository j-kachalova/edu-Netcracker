package org.example.NC.controller;

import com.sun.source.doctree.SeeTree;
import org.example.NC.domain.Human;
import org.example.NC.domain.NumberSIM;
import org.example.NC.domain.Role;
import org.example.NC.domain.SIMCard;
import org.example.NC.repos.NumberRepo;
import org.example.NC.repos.SIMCardRepo;
import org.example.NC.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    private SIMCardRepo simCardRepo;
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
        return "personalArea";
    }

    @PostMapping
    public String chooseKindSIM( @RequestParam String kind,
                                 SIMCard simCard) {
        //model.put("human", userRepo.findByUsername(user.getUsername()));
        simCard.setKind(kind);
        simCardRepo.save(simCard);
        return "/purchase2";
    }
    @GetMapping("/purchase")
    public String buy(Human user, Map<String, Object> model) {
        //Human userFromDb = userRepo.findByUsername(user.getUsername());
        Human userFromDb = (Human) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        List<NumberSIM> number = StreamSupport.stream(numberRepo.findAll().spliterator(), false)
                .filter(x -> !x.isUsed())
                .collect(Collectors.toList());
        for(int i=0; i<number.size(); i++) {
            System.out.println(number.get(i).toString());
        }
        if (userFromDb != null) {
            model.put("human", userFromDb);
            model.put("num", number);
            return "purchase";
        }
        /*List<NumberSIM> number = numberRepo.findAll().stream().filter(x-> x.isUsed()==false).collect(Collectors.toList());
        System.out.println(number);*/
        //Iterable<NumberSIM> num;
        /*List<NumberSIM> number = StreamSupport.stream(numberRepo.findAll().spliterator(), false)
                .filter(x -> !x.isUsed())
                .collect(Collectors.toList());*/
       /* List<NumberSIM> numbers = numberRepo.findAll();
        for(int i=0; i<numbers.size(); i++){
            System.out.println(numbers.get(i).toString());
        }*/
        /*List<NumberSIM> list = new ArrayList<>();
        list.add(new NumberSIM(1, "ertyuiop;'", false, null));
        model.put("num", new NumberSIM(1, "ertyuiop;'", false, null));*/
        return "purchase";
    }
    @PostMapping("/sim")
    public String chooseNum(Human user, Map<String, Object> model) {
        //model.put("human", userRepo.findByUsername(user.getUsername()));
        return "/sim2";
    }
}
