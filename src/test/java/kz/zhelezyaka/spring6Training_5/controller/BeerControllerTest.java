package kz.zhelezyaka.spring6Training_5.controller;

import kz.zhelezyaka.spring6Training_5.model.Beer;
import kz.zhelezyaka.spring6Training_5.services.BeerServices;
import kz.zhelezyaka.spring6Training_5.services.BeerServicesImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerServices beerServices;

    BeerServicesImpl beerServicesImpl = new BeerServicesImpl();

    @Test
    void getBeerById() throws Exception {
        Beer testBeer = beerServicesImpl.listBeers().get(0);

        given(beerServices.getBeerById(any(UUID.class)))
                .willReturn(testBeer);

        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}