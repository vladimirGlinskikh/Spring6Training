package kz.zhelezyaka.spring6Training_3.controllers;

import kz.zhelezyaka.spring6Training_3.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {
    GreetingService greetingService;

    public PropertyInjectedController(@Qualifier("propertyGreetingService")
                                      GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String callIs() {
        return greetingService.sayGreeting();
    }
}
