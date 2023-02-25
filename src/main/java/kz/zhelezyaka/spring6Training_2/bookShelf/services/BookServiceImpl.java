package kz.zhelezyaka.spring6Training_2.bookShelf.services;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Book;
import kz.zhelezyaka.spring6Training_2.bookShelf.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
