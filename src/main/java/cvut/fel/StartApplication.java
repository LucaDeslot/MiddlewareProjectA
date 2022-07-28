package cvut.fel;

import cvut.fel.entity.*;
import cvut.fel.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class  StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        Address add1 = new Address();
        Author auth = new Author();
        Book book = new Book();
        Library lib = new Library();
        lib.setName("MaLib");
        book.setTitle("Titre du livre");
        auth.setName("Jean");
        add1.setCity("TAMER");
        addressRepository.save(add1);
        authorRepository.save(auth);
        bookRepository.save(book);
        book.addAuthor(auth);
        bookRepository.save(book);
        lib.addBook(book);
        libraryRepository.save(lib);
        PublishingHouse pubHouse = new PublishingHouse();
        pubHouse.setName("PubHouse");
        pubHouse.addAuthor(auth);
        pubHouse.addPublishedBook(book);
        publishingHouseRepository.save(pubHouse);

        System.out.println("\nfindAll()");
        addressRepository.findAll().forEach(System.out::println);
        authorRepository.findAll().forEach(System.out::println);
        bookRepository.findAll().forEach(System.out::println);
        libraryRepository.findAll().forEach(System.out::println);
        publishingHouseRepository.findAll().forEach(System.out::println);

        System.out.println("Test: ");

    }

}