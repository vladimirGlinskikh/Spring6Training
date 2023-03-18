package kz.zhelezyaka.spring6Training_5.mappers;

import kz.zhelezyaka.spring6Training_5.entities.Beer;
import kz.zhelezyaka.spring6Training_5.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDTOToBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
