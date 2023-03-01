package kz.zhelezyaka.spring6Training_3.services.i18n;

import kz.zhelezyaka.spring6Training_3.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("RU")
@Service("i18NService")
public class RussianGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Вызов из класса RussianGreetingService на русском - RU";
    }
}
