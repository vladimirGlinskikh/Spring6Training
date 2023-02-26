package kz.zhelezyaka.spring6Training_3.controllers;

import kz.zhelezyaka.spring6Training_3.services.GreetingService;

public class PropertyInjectedController {
    GreetingService greetingService;

    public String callIs() {
        return greetingService.sayGreeting();
    }
}
