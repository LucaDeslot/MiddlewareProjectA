package cvut.fel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO extends AbstractDTO{

    private String city;
    private String street;
    private int houseNumber;
    public AddressDTO(AddressDTO dto) {
        super(dto);
        this.city = dto.getCity();
        this.street = dto.getStreet();
        this.houseNumber = dto.getHouseNumber();
    }



    @Override
    public AbstractDTO clone() {
        return new AddressDTO(this);
    }
}
