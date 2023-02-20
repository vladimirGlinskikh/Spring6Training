package kz.zhelezyaka.Spring6Training.bootstrap;

import kz.zhelezyaka.Spring6Training.domain.Author;
import kz.zhelezyaka.Spring6Training.domain.Book;
import kz.zhelezyaka.Spring6Training.domain.Publisher;
import kz.zhelezyaka.Spring6Training.repositories.AuthorRepository;
import kz.zhelezyaka.Spring6Training.repositories.BookRepository;
import kz.zhelezyaka.Spring6Training.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Thompson");

        Book book = new Book();
        book.setTitle("Spring framework from Beginners to Guru");
        book.setIsbn("1243231289");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("O'Reilly");
        publisher.setAddress("658 Goosetown Drive");
        publisher.setCity("Matthews");
        publisher.setState("North Carolina");
        publisher.setZip(28105);

        Author johnSaved = authorRepository.save(john);
        Book bookSaved = bookRepository.save(book);
        Publisher publisherSaved1 = publisherRepository.save(publisher);

        Author laur = new Author();
        john.setFirstName("Laur");
        john.setLastName("Spilca");

        Book book1 = new Book();
        book.setTitle("Spring Security in Action");
        book.setIsbn("34367425476");

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Maning");
        publisher1.setAddress("2732 Hardman Road");
        publisher1.setCity("Brattleboro");
        publisher1.setState("Vermont");
        publisher1.setZip(05301);

        Author laurSaved = authorRepository.save(laur);
        Book book1Saved = bookRepository.save(book1);
        Publisher publisherSaved2 = publisherRepository.save(publisher1);

        johnSaved.getBooks().add(bookSaved);
        laurSaved.getBooks().add(book1Saved);

        bookSaved.setPublisher(publisherSaved1);
        book1Saved.setPublisher(publisherSaved2);

        authorRepository.save(johnSaved);
        authorRepository.save(laurSaved);
        bookRepository.save(bookSaved);
        bookRepository.save(book1Saved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
