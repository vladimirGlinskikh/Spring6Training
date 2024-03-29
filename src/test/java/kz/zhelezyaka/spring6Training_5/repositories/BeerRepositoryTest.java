package kz.zhelezyaka.spring6Training_5.repositories;

import jakarta.validation.ConstraintViolationException;
import kz.zhelezyaka.spring6Training_5.bootstrap.BootstrapData;
import kz.zhelezyaka.spring6Training_5.entities.Beer;
import kz.zhelezyaka.spring6Training_5.model.BeerStyle;
import kz.zhelezyaka.spring6Training_5.services.BeerCsvServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testGetBeerListByName() {
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);
        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void testSaveBeerNameTooLong() {
        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("some beer 1233792793482610942342039420759248611589131425687683583769")
                    .beerStyle(BeerStyle.LAGER)
                    .upc("252323489")
                    .price(new BigDecimal("12.45"))
                    .build());
            beerRepository.flush();
        });
    }

    @Test
    void testSaveBeer() {
        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("some beer")
                .beerStyle(BeerStyle.LAGER)
                .upc("252323489")
                .price(new BigDecimal("12.45"))
                .build());
        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}