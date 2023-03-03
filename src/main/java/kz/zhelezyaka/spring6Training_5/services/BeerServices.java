package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.Beer;

import java.util.UUID;

public interface BeerServices {
    Beer getBeerById(UUID id);
}
