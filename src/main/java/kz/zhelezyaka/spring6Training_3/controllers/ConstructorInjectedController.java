package kz.zhelezyaka.spring6Training_3.controllers;

import kz.zhelezyaka.spring6Training_3.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private final GreetingService greetingService;

    public ConstructorInjectedController(@Qualifier("greetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String callIs() {
        return greetingService.sayGreeting();
    }
}
