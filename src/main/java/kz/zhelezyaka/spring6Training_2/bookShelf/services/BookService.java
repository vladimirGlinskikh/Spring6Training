package kz.zhelezyaka.spring6Training_2.bookShelf.services;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
