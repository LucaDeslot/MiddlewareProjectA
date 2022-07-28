package cvut.fel.controller;

import cvut.fel.dto.AddressDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AddressController {
    private final AddressService addressService;
    private final DTOMapper dtoMapper;

    @Autowired
    public AddressController(AddressService addressService, DTOMapper dtoMapper) {
        this.addressService = addressService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.addressToDto(addressService.findById(id)));
    }
}
