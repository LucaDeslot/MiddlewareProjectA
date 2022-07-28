package cvut.fel.dto;

import cvut.fel.entity.Author;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO extends AbstractDTO{
    private String ISBN;
    private String title;
    private ArrayList<Author> authors = new ArrayList<>();
    //private PublishingHouse publisher;
    private String genre;
    private Date publication_date;
    private String type;

    public BookDTO(BookDTO dto) {
        super(dto);
        this.ISBN = dto.getISBN();
        this.title = dto.getTitle();
        this.authors = dto.getAuthors();
       // this.publisher = dto.getPublisher();
        this.genre = dto.getGenre();
        this.publication_date = dto.getPublication_date();
        this.type = dto.getType();

    }

    @Override
    protected AbstractDTO clone() {
        return null;
    }
}
