package com.jason.integrationweb.paramconverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ParamController {
    @GetMapping("/Para")
    public void hello(Date birth){
        System.out.println(birth);
    }

}
