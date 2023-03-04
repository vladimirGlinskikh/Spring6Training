package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerServices {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);
}
