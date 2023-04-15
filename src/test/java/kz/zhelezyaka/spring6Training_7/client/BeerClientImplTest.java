package kz.zhelezyaka.spring6Training_7.client;

import kz.zhelezyaka.spring6Training_7.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    BeerClientImpl beerClient;

    @Test
    void getBeerById() {
        Page<BeerDTO> beerDTOS = beerClient.listBeers();
        BeerDTO dto = beerDTOS.getContent().get(0);
        BeerDTO byId = beerClient.getBeerById(dto.getId());
        assertNotNull(byId);
    }

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