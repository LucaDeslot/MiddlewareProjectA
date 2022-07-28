package cvut.fel.dto;


import cvut.fel.entity.Address;
import cvut.fel.entity.Author;
import cvut.fel.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class PublishingHouseDTO extends AbstractDTO{

    private String name;
    private Address address;
    private ArrayList<Author> authors = new ArrayList<>();
    private ArrayList<Book> published_books = new ArrayList<>();

    public PublishingHouseDTO(PublishingHouseDTO dto){
        this.name = this.getName();
        this.authors = this.getAuthors();
        this.address = this.getAddress();
        this.published_books = this.getPublished_books();
    }


    @Override
    protected AbstractDTO clone() {
        return null;
    }
}
