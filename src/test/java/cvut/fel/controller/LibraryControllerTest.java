package cvut.fel.controller;

import cvut.fel.entity.Book;
import cvut.fel.entity.Library;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.LibraryRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryControllerTest {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryController libraryController;

    @Test
    void getAccountById() {

    }

    @Test
    void addBookToLibrary() {
        Book book = new Book();
        book.setTitle("My Title");
        Library lib = new Library();
        lib.setName("My Library");
        bookRepository.save(book);
        libraryRepository.save(lib);
        libraryController.addBookToLibrary(book.getId(), lib.getId());
        libraryRepository.findAll().forEach(System.out::println);
        assertTrue(libraryRepository.findById(lib.getId()).get().getBooks().stream().anyMatch(book1 -> book1.getId() == book.getId()));
    }
}