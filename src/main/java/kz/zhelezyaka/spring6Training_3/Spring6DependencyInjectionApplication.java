package kz.zhelezyaka.spring6Training_3;

import kz.zhelezyaka.spring6Training_3.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring6DependencyInjectionApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring6DependencyInjectionApplication.class, args);
        MyController controller = context.getBean(MyController.class);
        System.out.println("In Main method");
        System.out.println(controller.sayHello());
    }
}
