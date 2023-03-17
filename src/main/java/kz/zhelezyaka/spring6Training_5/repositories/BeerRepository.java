package kz.zhelezyaka.spring6Training_5.repositories;

import kz.zhelezyaka.spring6Training_5.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
