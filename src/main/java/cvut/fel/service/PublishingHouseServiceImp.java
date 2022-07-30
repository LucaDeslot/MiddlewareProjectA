package cvut.fel.service;

import cvut.fel.entity.Author;
import cvut.fel.entity.PublishingHouse;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AuthorRepository;
import cvut.fel.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingHouseServiceImp implements PublishingHouseService{
    private final PublishingHouseRepository publishingHouseRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public PublishingHouseServiceImp(PublishingHouseRepository publishingHouseRepository, AuthorRepository authorRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
        this.authorRepository = authorRepository;
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

    public PublishingHouse createContract(Long idPublishingHouse, Long idAuthor){
        if (idPublishingHouse == null || idAuthor == null)
            throw new FieldMissingException();

        PublishingHouse publishingHouse = publishingHouseRepository.findById(idPublishingHouse).orElseThrow(() -> new NotFoundException("PUBLISHING_HOUSE_NOT_FOUND"));
        Author author = authorRepository.findById(idAuthor).orElseThrow(() -> new NotFoundException("AUTHOR_NOT_FOUND"));

        if(checkAuthor(publishingHouse, author)){
            author.getPublishing_houses().add(publishingHouse);
            publishingHouse.getAuthors().add(author);
            publishingHouseRepository.save(publishingHouse);
            authorRepository.save(author);
            return publishingHouse;
        }else{
            throw  new NotFoundException("AUTHOR_ALREADY_IN_PUBLISHING_HOUSE");
        }

    }
}
