package kz.zhelezyaka.Spring6Training.bootstrap;

import kz.zhelezyaka.Spring6Training.domain.Author;
import kz.zhelezyaka.Spring6Training.domain.Book;
import kz.zhelezyaka.Spring6Training.repositories.AuthorRepository;
import kz.zhelezyaka.Spring6Training.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Thompson");

        Book book = new Book();
        book.setTitle("Spring framework from Beginners to Guru");
        book.setIsbn("1243231289");

        Author johnSaved = authorRepository.save(john);
        Book bookSaved = bookRepository.save(book);

        Author laur = new Author();
        john.setFirstName("Laur");
        john.setLastName("Spilca");

        Book book1 = new Book();
        book.setTitle("Spring Security in Action");
        book.setIsbn("34367425476");

        Author laurSaved = authorRepository.save(laur);
        Book book1Saved = bookRepository.save(book1);

        johnSaved.getBooks().add(bookSaved);
        laurSaved.getBooks().add(book1Saved);

        authorRepository.save(johnSaved);
        authorRepository.save(laurSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
