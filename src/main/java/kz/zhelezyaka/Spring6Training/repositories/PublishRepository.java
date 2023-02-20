package kz.zhelezyaka.Spring6Training.repositories;

import kz.zhelezyaka.Spring6Training.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher, Long> {
}
