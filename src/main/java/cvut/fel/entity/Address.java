package cvut.fel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class Address extends AbstractEntity {
    private String city;
    private String street;
    private int houseNumber;

    @Override
    public String toString() {
        return city;
    }
}

