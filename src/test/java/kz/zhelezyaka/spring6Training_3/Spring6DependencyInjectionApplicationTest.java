package kz.zhelezyaka.spring6Training_3;

import kz.zhelezyaka.spring6Training_3.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Spring6DependencyInjectionApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    MyController myController;

    @Test
    void testAutowiredOfController() {
        System.out.println(myController.sayHello());
    }

    @Test
    void testGetControllerFromContext() {
        MyController myController = applicationContext.getBean(MyController.class);
        System.out.println(myController.sayHello());
    }

    @Test
    void contextLoads() {

    }
}