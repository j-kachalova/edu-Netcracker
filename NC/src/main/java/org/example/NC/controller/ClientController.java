package org.example.NC.controller;

import com.fasterxml.jackson.datatype.jdk8.OptionalIntDeserializer;
import com.sun.source.doctree.SeeTree;
import net.bytebuddy.dynamic.DynamicType;
import org.apache.catalina.startup.ListenerCreateRule;
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
    private final Integer price = 200;
    private BuyingDTO simCardDTO = new BuyingDTO();

    @GetMapping("/personalArea")
    public String personalArea() {
        return "personalArea";
    }
    @PostMapping("/personalArea")
    public String buying(SIMCard simCard, NumberSIM numberSIM ) {
        simCard.setNumber(simCardDTO.getNumber());
        simCard.setKind(simCardDTO.getKind());
        System.out.println(simCard);
        simCardRepo.save(simCard);
        numberSIM = numberRepo.findByNum(simCard.getNumber());
        numberSIM.setUsed(true);
        numberRepo.save(numberSIM);
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
        numberSIM = numberRepo.findByNum(simCardDTO.getNumber());
        if(kind=="physical") simCardDTO.setPrice(numberSIM.getPrice() + price);
        else simCardDTO.setPrice(numberSIM.getPrice());
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
    public String submitTariff(@RequestParam Integer tariffId, Optional<Tariff> tariff, Model model) {
        System.out.println(tariffId);
        tariff = tariffRepo.findById(tariffId);
        System.out.println(tariff.get().toString());
        simCardDTO.setTariff(tariff.get());
        if(simCardDTO.getKind()=="physical") return "purchase2";
        model.addAttribute("human", simCardDTO.getUser());
        model.addAttribute("number", simCardDTO.getNumber());
        model.addAttribute("tariff", simCardDTO.getTariff().getName());
        model.addAttribute("price", simCardDTO.getPrice());
        return "result";
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
            simCardDTO.setUser(userFromDb);
            model.put("human", userFromDb);
            model.put("num", number);
            model.put("simCard", simCard);
            return "purchase";
        }

        return "purchase";
    }

}
