package ru.kachalova.nc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/home")
    public String sayHello(){
        return "/WEB-INF/views/index.html";
    }
}
