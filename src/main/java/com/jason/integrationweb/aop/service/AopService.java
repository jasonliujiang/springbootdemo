package com.jason.integrationweb.aop.service;

import org.springframework.stereotype.Service;

@Service
public class AopService {
    public String getAopById(Integer id){
        System.out.println("getAopById");
        return "Jason";
    }

    public void deleteById(Integer id){
        System.out.println("deleteById");
    }
}
