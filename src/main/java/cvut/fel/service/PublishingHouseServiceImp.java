package cvut.fel.service;

import cvut.fel.entity.PublishingHouse;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PublishingHouseServiceImp {
    private final PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public PublishingHouseServiceImp(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }

    public PublishingHouse findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return publishingHouseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }
}
