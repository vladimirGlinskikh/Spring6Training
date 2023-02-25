package kz.zhelezyaka.spring6Training_2.bookShelf.bootstrap;

import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Author;
import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Book;
import kz.zhelezyaka.spring6Training_2.bookShelf.domain.Publisher;
import kz.zhelezyaka.spring6Training_2.bookShelf.repositories.AuthorRepository;
import kz.zhelezyaka.spring6Training_2.bookShelf.repositories.BookRepository;
import kz.zhelezyaka.spring6Training_2.bookShelf.repositories.PublishRepository;
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

        Book johnBook = new Book();
        johnBook.setTitle("Spring framework from Beginners to Guru");
        johnBook.setIsbn("1243231289");

        Publisher johnPublisher = new Publisher();
        johnPublisher.setPublisherName("O'Reilly");
        johnPublisher.setAddress("658 Goosetown Drive");
        johnPublisher.setCity("Matthews");
        johnPublisher.setState("North Carolina");
        johnPublisher.setZip(28105);

        Author johnSaved = authorRepository.save(john);
        Book johnBookSaved = bookRepository.save(johnBook);
        Publisher johnPublisherSaved = publisherRepository.save(johnPublisher);

        System.out.println("------------------------------------");

        Author laur = new Author();
        laur.setFirstName("Laur");
        laur.setLastName("Spilca");

        Book laurBook = new Book();
        laurBook.setTitle("Spring Security in Action");
        laurBook.setIsbn("34367425476");

        Publisher laurPublisher = new Publisher();
        laurPublisher.setPublisherName("Maning");
        laurPublisher.setAddress("2732 Hardman Road");
        laurPublisher.setCity("Brattleboro");
        laurPublisher.setState("Vermont");
        laurPublisher.setZip(05301);

        Author laurSaved = authorRepository.save(laur);
        Book laurBookSaved = bookRepository.save(laurBook);
        Publisher laurPublisherSaved = publisherRepository.save(laurPublisher);

        johnSaved.getBooks().add(johnBookSaved);
        laurSaved.getBooks().add(laurBookSaved);
        johnBookSaved.getAuthors().add(johnSaved);
        laurBookSaved.getAuthors().add(laurSaved);

        johnBookSaved.setPublisher(johnPublisherSaved);
        laurBookSaved.setPublisher(laurPublisherSaved);

        authorRepository.save(johnSaved);
        authorRepository.save(laurSaved);
        bookRepository.save(johnBookSaved);
        bookRepository.save(laurBookSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
