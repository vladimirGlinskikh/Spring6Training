package kz.zhelezyaka.spring6Training_2.bookShelf.repositories;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
