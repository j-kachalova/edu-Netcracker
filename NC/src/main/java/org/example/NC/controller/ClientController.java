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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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


    @GetMapping("/personalArea")
    public String personalArea() {
        return "personalArea";
    }
    @PostMapping("/personalArea")
    public String buying(SIMCard simCard, NumberSIM numberSIM, @RequestParam String kind, @RequestParam String number, @RequestParam Integer resultPrice, @RequestParam Integer tariffId, Optional<Tariff> tariff) {
        simCard.setNumber(number);
        simCard.setKind(kind);
        System.out.println(simCard.toString());
        //simCardRepo.save(simCard);

        /*numberSIM = numberRepo.findByNum(simCard.getNumber());
        numberSIM.setUsed(true);
        numberRepo.save(numberSIM);*/
        return "personalArea";
    }
    @PostMapping("/purchase1")
    public String submitNum(@RequestParam String number, Model model) {
        model.addAttribute("number",number);
        System.out.println(number);
        return "purchase1";
    }
    @PostMapping("/purchase3")
    public String submitKindSIM(@RequestParam String kind, @RequestParam String number, SIMCard simCard, NumberSIM numberSIM, Map<String, Object> model) {
        numberSIM = numberRepo.findByNum(number);
        Integer resultPrice;
        if(kind=="physical") resultPrice= numberSIM.getPrice() + price;
        else resultPrice= numberSIM.getPrice();
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
        model.put("number",number);
        model.put("kind", kind);
        model.put("resultPrice", resultPrice);
        System.out.println(number);
        System.out.println(kind);
        return "purchase3";
    }
    @PostMapping("/purchase2")
    public String submitTariff(RedirectAttributes redirectAttributes, @RequestParam String kind, @RequestParam String number, @RequestParam Integer resultPrice, @RequestParam Integer tariffId, Optional<Tariff> tariff, Model model) {
        System.out.println(tariffId);
        if(kind=="physical") return "purchase2";
        redirectAttributes.addFlashAttribute("number", number);
        redirectAttributes.addFlashAttribute("kind", kind);
        redirectAttributes.addFlashAttribute("tariffId", tariffId);
        redirectAttributes.addFlashAttribute("resultPrice", resultPrice);
        return "redirect:/result";
    }
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String viewResult(Model model, Optional<Tariff> tariff){
        String number = (String)model.asMap().get("number");
        String kind = (String)model.asMap().get("kind");
        Integer tariffId = (Integer) model.asMap().get("tariffId");
        tariff = tariffRepo.findById(tariffId);
        System.out.println(tariff.get().toString());
        Integer resultPrice = (Integer) model.asMap().get("resultPrice");
        Human userFromDb = (Human) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        model.addAttribute("human", userFromDb);
        model.addAttribute("number", number);
        model.addAttribute("kind", kind);
        model.addAttribute("tariff", tariff.get());
        model.addAttribute("resultPrice", resultPrice);
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
            //simCardDTO.setUser(userFromDb);
            model.put("human", userFromDb);
            model.put("num", number);
            model.put("simCard", simCard);
            return "purchase";
        }

        return "purchase";
    }

}
