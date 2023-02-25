package kz.zhelezyaka.spring6Training_3.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String sayHello(){
        System.out.println("Hello controller");
        return "Hello everyone spring guru.";
    }
}
