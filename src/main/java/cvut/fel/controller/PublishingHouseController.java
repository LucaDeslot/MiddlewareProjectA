package cvut.fel.controller;

import cvut.fel.dto.DTOMapper;
import cvut.fel.dto.PublishingHouseDTO;
import cvut.fel.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class PublishingHouseController {
    private final PublishingHouseService publishingHouseService;
    private final DTOMapper dtoMapper;

    @Autowired
    public PublishingHouseController(PublishingHouseService publishingHouseService, DTOMapper dtoMapper) {
        this.publishingHouseService = publishingHouseService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<PublishingHouseDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.publishingHouseToDto(publishingHouseService.findById(id)));
    }
}
