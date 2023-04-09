package kz.zhelezyaka.spring6Training_7.client;

import kz.zhelezyaka.spring6Training_7.model.BeerDTO;
import org.springframework.data.domain.Page;

public interface BeerClient {
    Page<BeerDTO> listBeers();
}
