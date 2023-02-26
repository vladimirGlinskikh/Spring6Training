package kz.zhelezyaka.spring6Training_3.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConstructorInjectedControllerTest {
    @Autowired
    ConstructorInjectedController controller;

    @Test
    void callIs() {
        System.out.println(controller.callIs());
    }
}