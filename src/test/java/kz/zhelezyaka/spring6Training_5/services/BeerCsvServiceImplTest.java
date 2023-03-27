package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.BeerCSVRecord;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BeerCsvServiceImplTest {
    BeerCsvService beerCsvService = new BeerCsvServiceImpl();

    @Test
    void convertCSV() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:csvdata/beer.csv");
        List<BeerCSVRecord> recordList = beerCsvService.convertCSV(file);
        System.out.println(recordList.size());
        assertThat(recordList.size()).isGreaterThan(0);
    }
}