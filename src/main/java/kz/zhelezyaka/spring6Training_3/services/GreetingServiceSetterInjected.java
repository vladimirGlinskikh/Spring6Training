package kz.zhelezyaka.spring6Training_3.services;

import org.springframework.stereotype.Service;

@Service("setterGreetingBean")
public class GreetingServiceSetterInjected implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Call from GreetingServiceSetterInjected class...";
    }
}
