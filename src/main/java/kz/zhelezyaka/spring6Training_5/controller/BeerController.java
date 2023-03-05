package kz.zhelezyaka.spring6Training_5.controller;

import kz.zhelezyaka.spring6Training_5.model.Beer;
import kz.zhelezyaka.spring6Training_5.services.BeerServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerServices beerServices;

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerServices.saveNewBeer(beer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location",
                "/api/v1/beer/" +
                        savedBeer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {
        return beerServices.listBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("Get Beer by id - in controller");
        return beerServices.getBeerById(beerId);
    }
}
