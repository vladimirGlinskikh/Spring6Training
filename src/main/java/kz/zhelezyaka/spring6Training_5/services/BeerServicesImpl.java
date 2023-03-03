package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.Beer;
import kz.zhelezyaka.spring6Training_5.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServicesImpl implements BeerServices {
    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Get Beer id in service. id: " + id.toString());
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Rudnenskoe")
                .beerStyle(BeerStyle.ALE)
                .upc("1234")
                .price(new BigDecimal("10.89"))
                .quantityOnHand(123)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
