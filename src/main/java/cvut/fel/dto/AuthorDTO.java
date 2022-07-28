package cvut.fel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDTO extends AbstractDTO{

    private String name;
    private String surname;
    private String mail;
    //private ArrayList<Book> books = new ArrayList<>();
    //private ArrayList<PublishingHouse> publishing_houses = new ArrayList<>();

    public AuthorDTO(AuthorDTO dto) {
        super(dto);
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.mail = dto.getMail();
        //this.books = dto.getBooks();
        //this. publishing_houses = dto.getPublishing_houses();
    }

    @Override
    protected AbstractDTO clone() {
        return null;
    }
}
