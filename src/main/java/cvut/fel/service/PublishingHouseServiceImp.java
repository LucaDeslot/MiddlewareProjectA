package cvut.fel.service;

import cvut.fel.entity.Author;
import cvut.fel.entity.Book;
import cvut.fel.entity.Library;
import cvut.fel.entity.PublishingHouse;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.LibraryRepository;
import cvut.fel.repository.PublishingHouseRepository;
import cvut.fel.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingHouseServiceImp implements PublishingHouseService{
    private final PublishingHouseRepository publishingHouseRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    @Autowired
    public PublishingHouseServiceImp(PublishingHouseRepository publishingHouseRepository, AuthorRepository authorRepository, BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    public PublishingHouse findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return publishingHouseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }

    public boolean checkAuthor(PublishingHouse publishingHouse, Author author){
        return !publishingHouse.getAuthors().contains(author);
    }

    public boolean checkBookNotPublished(PublishingHouse publishingHouse, Book book){
        return !publishingHouse.getPublished_books().contains(book);
    }

    public PublishingHouse createContract(Long idPublishingHouse, Long idAuthor){
        if (idPublishingHouse == null || idAuthor == null)
            throw new FieldMissingException();

        PublishingHouse publishingHouse = publishingHouseRepository.findById(idPublishingHouse).get();
        Author author = authorRepository.findById(idAuthor).get();

        if(checkAuthor(publishingHouse, author)){
            author.addPublishingHouse(publishingHouse);
            authorRepository.save(author);
            publishingHouse.addAuthor(author);
            publishingHouseRepository.save(publishingHouse);
            return publishingHouse;
        }else{
            throw  new NotFoundException("AUTHOR_ALREADY_IN_PUBLISHING_HOUSE");
        }

    }

    public PublishingHouse publishNewBook(Long idBook, Long idPublishingHouse){
        if (idBook == null || idPublishingHouse == null)
            throw new FieldMissingException();

        PublishingHouse publishingHouse = publishingHouseRepository.findById(idPublishingHouse).get();
        Book book = bookRepository.findById(idBook).get();

        if(checkBookNotPublished(publishingHouse, book)){
            publishingHouse.addPublishedBook(book);
            publishingHouseRepository.save(publishingHouse);
            return publishingHouse;
        }else{
            throw  new NotFoundException("BOOK_ALREADY_PUBLISHED");
        }

    }
}
