package org.example.NC.controller;

import com.sun.source.doctree.SeeTree;
import org.example.NC.domain.*;
import org.example.NC.repos.NumberRepo;
import org.example.NC.repos.SIMCardRepo;
import org.example.NC.repos.TariffRepo;
import org.example.NC.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Controller
@PreAuthorize("hasAuthority('USER')")
public class ClientController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SIMCardRepo simCardRepo;
    @Autowired
    private NumberRepo numberRepo;
    @Autowired
    private TariffRepo tariffRepo;
    private BuyingDTO simCardDTO = new BuyingDTO();

    @GetMapping("/personalArea")
    public String personalArea(Map<String, Object> model) {
        return "personalArea";
    }
    @PostMapping("/purchase1")
    public String submitNum(@RequestParam String number) {
        simCardDTO.setNumber(number);
        System.out.println(simCardDTO);
        return "purchase1";
    }
    @PostMapping("/purchase3")
    public String submitKindSIM(@RequestParam String kind, SIMCard simCard, NumberSIM numberSIM, Map<String, Object> model) {
        simCardDTO.setKind(kind);
        /*simCard.setNumber(simCardDTO.getNumber());
        simCard.setKind(simCardDTO.getKind());
        System.out.println(simCard);
        simCardRepo.save(simCard);
        numberSIM = numberRepo.findByNum(simCard.getNumber());
        numberSIM.setUsed(true);
        numberRepo.save(numberSIM);*/
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
        return "purchase3";
    }
    @PostMapping("/purchase2")
    public String submitTariff(@RequestParam Integer tariffId, Optional<Tariff> tariff) {
        System.out.println(tariffId);
        tariff = tariffRepo.findById(tariffId);
        System.out.println(tariff.get().toString());
        simCardDTO.setTariff(tariff.get());
        return "purchase2";
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

}
