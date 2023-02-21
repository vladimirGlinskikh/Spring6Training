package kz.zhelezyaka.Spring6Training.services;

import kz.zhelezyaka.Spring6Training.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
