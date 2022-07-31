package cvut.fel.controller;

import cvut.fel.entity.Author;
import cvut.fel.entity.Book;
import cvut.fel.entity.PublishingHouse;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.PublishingHouseRepository;
import cvut.fel.service.PublishingHouseService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PublishingHouseControllerTest {

    @Autowired
    PublishingHouseRepository publishingHouseRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublishingHouseController publishingHouseController;

    @Test
    void createContract() {
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName("PubHouse");
        Author author = new Author();
        author.setName("My Author");
        publishingHouseRepository.save(publishingHouse);
        authorRepository.save(author);
        publishingHouseController.createContract(publishingHouse.getId(), author.getId());
        assertTrue(publishingHouseRepository.findById(publishingHouse.getId()).get().getAuthors().stream().anyMatch(author1 -> author1.getId() == author.getId()));
    }

    @Test
    void publishNewBook() {
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName("PubHouse");
        publishingHouseRepository.save(publishingHouse);
        Book book = new Book();
        book.setTitle("my title");
        bookRepository.save(book);
        publishingHouseController.publishNewBook(book.getId(), publishingHouse.getId());
        assertTrue(publishingHouseRepository.findById(publishingHouse.getId()).get().getPublished_books().stream().anyMatch(book1 -> book1.getId() == book.getId()));
    }
}