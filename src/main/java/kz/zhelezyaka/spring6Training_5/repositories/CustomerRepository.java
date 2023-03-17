package kz.zhelezyaka.spring6Training_5.repositories;

import kz.zhelezyaka.spring6Training_5.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
