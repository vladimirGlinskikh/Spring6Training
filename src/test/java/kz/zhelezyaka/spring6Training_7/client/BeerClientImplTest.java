package kz.zhelezyaka.spring6Training_7.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void listBeersNoBeerName() {
        beerClient.listBeers(
                null,
                null,
                null,
                null,
                null);
    }

    @Test
    void listBeers() {
        beerClient.listBeers(
                "LAGER",
                null,
                null,
                null,
                null);
    }
}