package cvut.fel.service;

import cvut.fel.entity.Book;
import cvut.fel.entity.Library;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.BookRepository;
import cvut.fel.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImp implements LibraryService{
    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;


    @Autowired
    public LibraryServiceImp(LibraryRepository libraryRepository, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
    }

    public Library findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return libraryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

    public Library addBookToLibrary(Long bookID, Long libraryID){
        Book book = null;
        Library library = null;
        if (bookID == null)
            throw new FieldMissingException();
        try {
            book = bookRepository.findById(bookID).get();
            library = libraryRepository.findById(libraryID).get();
        } catch (Exception e){
            System.out.println("The book or the library has not been found");
        }
        library.addBook(book);
        libraryRepository.save(library);
        return library;
    }
}
