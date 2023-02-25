package kz.zhelezyaka.spring6Training_2.bookShelf.services;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
