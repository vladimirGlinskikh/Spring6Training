package kz.zhelezyaka.spring6Training_7.client;

import kz.zhelezyaka.spring6Training_7.model.BeerDTO;
import kz.zhelezyaka.spring6Training_7.model.BeerDTOPageImpl;
import kz.zhelezyaka.spring6Training_7.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {
        return this.listBeers(
                null,
                null,
                null,
                null,
                null);
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle,
                                   Boolean showInventory, Integer pageNumber,
                                   Integer pageSize) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null) {
            uriComponentsBuilder.queryParam("beerName", beerName);
        }

        if (beerStyle != null) {
            uriComponentsBuilder.queryParam("beerStyle", beerStyle);
        }

        if (showInventory != null) {
            uriComponentsBuilder.queryParam("showInventory", showInventory);
        }

        if (pageNumber != null) {
            uriComponentsBuilder.queryParam("pageNumber", pageNumber);
        }

        if (pageSize != null) {
            uriComponentsBuilder.queryParam("pageSize", pageSize);
        }

        ResponseEntity<BeerDTOPageImpl> response =
                restTemplate.getForEntity(uriComponentsBuilder.toUriString(),
                        BeerDTOPageImpl.class);


        return response.getBody();
    }
}
