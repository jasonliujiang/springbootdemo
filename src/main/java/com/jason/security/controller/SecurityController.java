package com.jason.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/hello111")
    public String hello(){
        return "hello security !";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "hello admin !";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "hello user!";
    }
}
