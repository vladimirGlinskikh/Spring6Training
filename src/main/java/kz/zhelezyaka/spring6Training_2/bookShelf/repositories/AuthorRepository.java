package kz.zhelezyaka.spring6Training_2.bookShelf.repositories;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
