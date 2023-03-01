package kz.zhelezyaka.spring6Training_3.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"develop", "default"})
@Service
public class EnvironmentServiceDev implements EnvironmentService {
    @Override
    public String getEnvironment() {
        return "develop";
    }
}
