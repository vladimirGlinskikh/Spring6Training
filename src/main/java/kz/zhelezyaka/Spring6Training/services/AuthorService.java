package kz.zhelezyaka.Spring6Training.services;

import kz.zhelezyaka.Spring6Training.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
