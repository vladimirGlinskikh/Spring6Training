package kz.zhelezyaka.spring6Training_5.services;

import kz.zhelezyaka.spring6Training_5.model.BeerCSVRecord;

import java.io.File;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
