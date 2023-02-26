package kz.zhelezyaka.spring6Training_3.services;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Call from Base Service";
    }
}
