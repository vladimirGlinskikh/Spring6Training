package kz.zhelezyaka.spring6Training_5.repositories;

import kz.zhelezyaka.spring6Training_5.entities.BeerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerOrderRepository extends JpaRepository<BeerOrder, UUID> {
}
