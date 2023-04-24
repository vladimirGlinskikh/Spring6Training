package kz.zhelezyaka.spring6Training_7.client;

import kz.zhelezyaka.spring6Training_7.model.BeerDTO;
import kz.zhelezyaka.spring6Training_7.model.BeerStyle;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface BeerClient {
    Page<BeerDTO> listBeers();

    Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle,
                            Boolean showInventory, Integer pageNumber,
                            Integer pageSize);

    BeerDTO getBeerById(UUID beerId);

    BeerDTO createBeer(BeerDTO newDTO);

    void deleteBeer(UUID id);

    BeerDTO updateBeer(BeerDTO beerDTO);
}
