package kz.zhelezyaka.Spring6Training.repositories;

import kz.zhelezyaka.Spring6Training.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
