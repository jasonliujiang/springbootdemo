package com.jason.integrationweb.welcome;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcomeController {
    @GetMapping("/index")
    public String welcome(){
        return "index";
    }
}
