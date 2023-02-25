package kz.zhelezyaka.spring6Training_2.bookShelf.repositories;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublishRepository extends CrudRepository<Publisher, Long> {
}
