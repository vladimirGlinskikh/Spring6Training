package kz.zhelezyaka.spring6Training_5.repositories;

import jakarta.transaction.Transactional;
import kz.zhelezyaka.spring6Training_5.entities.Beer;
import kz.zhelezyaka.spring6Training_5.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BeerRepository beerRepository;
    Beer testBeer;

    @BeforeEach
    void setUp() {
        testBeer = beerRepository.findAll().get(0);
    }

    @Transactional
    @Test
    void testAddCategory() {
        Category savedCat = categoryRepository.save(Category.builder()
                .description("Sasha")
                .build());
        testBeer.addCategory(savedCat);
        Beer saveBeer = beerRepository.save(testBeer);
        System.out.println(saveBeer.getBeerName());
    }
}