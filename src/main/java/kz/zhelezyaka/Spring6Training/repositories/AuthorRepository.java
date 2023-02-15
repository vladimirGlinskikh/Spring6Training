package kz.zhelezyaka.Spring6Training.repositories;

import kz.zhelezyaka.Spring6Training.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
