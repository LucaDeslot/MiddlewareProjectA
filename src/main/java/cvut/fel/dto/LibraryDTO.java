package cvut.fel.dto;

import cvut.fel.entity.Address;
import cvut.fel.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LibraryDTO extends AbstractDTO{
    private String name;
    private Address address;
    private List<Book> books = new ArrayList<>();

    public LibraryDTO(LibraryDTO dto) {
        this.name = this.getName();
        this.address = this.getAddress();
        this.books = this.getBooks();
    }

    @Override
    protected AbstractDTO clone() {
        return null;
    }
}
