package com.jason.integrationweb.controlleradvice;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

//@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        Map<String,Object> map = model.asMap();
        Set<String> keyset = map.keySet();
        for (String key:keyset){
            System.out.println(key+":"+map.get(key));
        }

        return "hello";

    }
}
