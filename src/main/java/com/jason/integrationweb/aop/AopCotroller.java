package com.jason.integrationweb.aop;

import com.jason.integrationweb.aop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopCotroller {
    @Autowired
    AopService aopService;

    @GetMapping("/AOP/getId")
    public String getAopById(Integer id) {
        return aopService.getAopById(id);
    }

    @GetMapping("/AOP/deleteId")
    public void deleteAopById(Integer id) {
        aopService.deleteById(id);
    }
}
