package cvut.fel.service;

import cvut.fel.entity.Author;
import cvut.fel.entity.PublishingHouse;
import org.springframework.stereotype.Service;

public interface PublishingHouseService {
    PublishingHouse findById(Long id);
    boolean checkAuthor(PublishingHouse publishingHouse, Author idAuthor);
    PublishingHouse createContract(Long idPublishingHouse, Long idAuthor);

    public PublishingHouse publishNewBook(Long idBook, Long idPublishingHouse);
}
