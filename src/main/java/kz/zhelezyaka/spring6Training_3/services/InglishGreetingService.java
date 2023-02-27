package kz.zhelezyaka.spring6Training_3.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("EN")
@Service("i18NService")
public class InglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Call from EnglishGreetingService class - EN";
    }
}
