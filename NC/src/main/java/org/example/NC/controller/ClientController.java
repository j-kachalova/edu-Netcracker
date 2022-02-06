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
import org.springframework.web.bind.annotation.*;

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

    /*public String chooseTariff(@RequestParam String username,
                               @RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String patronymic,
                               @RequestParam Map<String, String> form,
                               @RequestParam("userId") Human user,
                               Model model){
        //model.addAttribute("users", userRepo.findAll());

        return "";
    }   */
    @Autowired
    private NumberRepo numberRepo;
    private SIMCard simCardDTO = new SIMCard();

    @GetMapping("/personalArea")
    public String personalArea(Map<String, Object> model) {
        return "personalArea";
    }

    /*@PostMapping("/sim1")
    public String chooseKindSIM( @RequestParam String kind,
                                 SIMCard simCard) {
        //model.put("human", userRepo.findByUsername(user.getUsername()));
        simCard.setKind(kind);
        simCardRepo.save(simCard);
        return "redirect:/purchase2";
    }*/
    @PostMapping("/purchase")
    public String submitNum(@RequestParam String number,  @ModelAttribute("simCard") SIMCard simCard) {
        simCard.setNumber(number);
        simCardDTO.setNumber(number);
        System.out.println(simCardDTO);
        return "purchase1";
    }
    @PostMapping("/purchase1")
    public String submitKindSIM(@RequestParam String kind /*@RequestParam("id")*/, @RequestParam String simCard, SIMCard newSim) {
        //simCard.setKind(kind);
        System.out.println(simCard);
        simCardDTO.setKind(kind);
        newSim.setNumber(simCardDTO.getNumber());
        newSim.setKind(simCardDTO.getKind());
        System.out.println(newSim);
        simCardRepo.save(newSim);
        return "purchase2";
    }
    @PostMapping("/purchase2")
    public String submitDelivery() {
        return "personalArea";
    }
    @GetMapping("/purchase")
    public String selectNum(Human user, Map<String, Object> model, @ModelAttribute("simCard") SIMCard simCard) {
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
            model.put("simCard", simCard);
            return "purchase";
        }

        return "purchase";
    }
    @GetMapping("/purchase/{simCard}")
    public String selectKindNum(/*@PathVariable SIMCard simCard*/Map<String, Object> model, @PathVariable String simCard) {
        model.put("simCard", simCard);
        return "purchase1";
    }
    @GetMapping("/purchase2")
    public String selectDelivery(  Map<String, Object> model) {

        return "purchase2";
    }
   /* @PostMapping("/sim1")
    public String chooseNum(Human user, Map<String, Object> model) {
        //model.put("human", userRepo.findByUsername(user.getUsername()));
        return "/sim2";
    }*/
}
