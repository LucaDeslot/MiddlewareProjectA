package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.PublishingHouseDTO;
import cvut.fel.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishingHouseController {
    @Autowired
    private final PublishingHouseService publishingHouseService;
    private final DTOMapper dtoMapper;

    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService, DTOMapper dtoMapper) {
        this.publishingHouseService = publishingHouseService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/publishingHouse/{id}")
    public ResponseEntity<PublishingHouseDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.publishingHouseToDto(publishingHouseService.findById(id)));
    }

    public ResponseEntity<PublishingHouseDTO> createContract(@PathVariable Long idPublishingHouse, Long idAuthor){
        return ResponseEntity.ok(dtoMapper.publishingHouseToDto(publishingHouseService.createContract(idPublishingHouse, idAuthor)));
    }

    public ResponseEntity<PublishingHouseDTO> publishNewBook(@PathVariable Long idBook, Long idPublishingHouse){
        return ResponseEntity.ok(dtoMapper.publishingHouseToDto(publishingHouseService.publishNewBook(idBook, idPublishingHouse)));
    }

}
