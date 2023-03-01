package kz.zhelezyaka.spring6Training_3.controllers.i18n;

import kz.zhelezyaka.spring6Training_3.controllers.Myi18NController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Myi18NControllerTestEN {

    @Autowired
    Myi18NController myi18NController;

    @Test
    void testCallEN() {
        System.out.println(myi18NController.callFrom());
    }
}
