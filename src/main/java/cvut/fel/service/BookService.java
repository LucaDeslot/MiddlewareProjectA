package cvut.fel.service;

import cvut.fel.entity.Book;

import java.util.ArrayList;
import java.util.Date;

public interface BookService {
    Book findById(Long id);
    Book createBook(String ISBN, String title, ArrayList<Long> authorIDs, Long publishingHouseId, String genre, Date publication_date, String type);
}
