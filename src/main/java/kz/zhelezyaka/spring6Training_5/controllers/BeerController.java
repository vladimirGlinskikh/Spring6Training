package kz.zhelezyaka.spring6Training_5.controllers;

import kz.zhelezyaka.spring6Training_5.services.BeerServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerServices beerServices;
}
