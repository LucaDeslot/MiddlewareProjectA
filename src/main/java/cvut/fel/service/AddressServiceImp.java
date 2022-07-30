package cvut.fel.service;

import cvut.fel.entity.Address;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImp(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ADDRESS_NOT_FOUND"));
    }
}
