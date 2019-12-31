package com.jason.devtools.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/hello")
    public String hello(String name){
        return "hello"+name;
    }

    @PostMapping("/test/addBook")
    public TestBook addBook(TestBook testBook){
        if (testBook!=null){
            return testBook;
        }else {
            return null;
        }


    }


}
