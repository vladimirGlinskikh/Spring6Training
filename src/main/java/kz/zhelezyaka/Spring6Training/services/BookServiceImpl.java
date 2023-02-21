package kz.zhelezyaka.Spring6Training.services;

import kz.zhelezyaka.Spring6Training.domain.Book;
import kz.zhelezyaka.Spring6Training.repositories.BookRepository;
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
