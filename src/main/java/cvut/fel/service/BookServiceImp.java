package cvut.fel.service;

import cvut.fel.entity.Book;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Service
public class BookServiceImp implements BookService{
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

    @Override
    public Book createBook(String ISBN, String title, ArrayList<Long> authorIDs, Long publishingHouseId, String genre, Date publication_date, String type) {
        return null;
    }
}
