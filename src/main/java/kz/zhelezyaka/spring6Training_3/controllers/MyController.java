package kz.zhelezyaka.spring6Training_3.controllers;

import kz.zhelezyaka.spring6Training_3.services.GreetingService;
import kz.zhelezyaka.spring6Training_3.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello() {
        System.out.println("Call from Controller");
        return greetingService.sayGreeting();
    }
}
