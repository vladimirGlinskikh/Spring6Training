package kz.zhelezyaka.spring6Training_3.controllers.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("RU")
@SpringBootTest
public class Myi18NControllerTestRU {

    @Autowired
    Myi18NController myi18NController;

    @Test
    void testCallRU() {
        System.out.println(myi18NController.callFrom());
    }
}
