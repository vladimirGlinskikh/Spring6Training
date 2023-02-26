package kz.zhelezyaka.spring6Training_3.controllers;

import kz.zhelezyaka.spring6Training_3.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorInjectedControllerTest {
    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    void callIs() {
        System.out.println(controller.callIs());
    }
}