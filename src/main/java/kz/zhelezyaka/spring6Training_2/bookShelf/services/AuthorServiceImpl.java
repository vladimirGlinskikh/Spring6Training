package kz.zhelezyaka.spring6Training_2.bookShelf.services;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Author;
import kz.zhelezyaka.spring6Training_2.bookShelf.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
