package com.java.pk.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tomasz on 2017-11-15.
 */
@RestController
public class MainController {

    @RequestMapping("/")
    public String sayHello(){
        System.out.println("jestem");
        return "hello";
    }
}
