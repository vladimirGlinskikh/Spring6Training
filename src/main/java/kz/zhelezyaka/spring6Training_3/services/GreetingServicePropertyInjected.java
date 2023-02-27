package kz.zhelezyaka.spring6Training_3.services;

import org.springframework.stereotype.Service;

@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Call from GreetingServicePropertyInjected class...";
    }
}
