package kz.zhelezyaka.spring6Training_3.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Production")
@Service
public class EnvironmentServiceProduction implements EnvironmentService {
    @Override
    public String getEnvironment() {
        return "Production";
    }
}
