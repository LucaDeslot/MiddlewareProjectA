package cvut.fel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.*;

@Entity

@Getter @Setter @NoArgsConstructor
public class Book extends AbstractEntity{
    private String ISBN;
    private String title;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_id")
    private List<Author> authors = new ArrayList<>();
    //private PublishingHouse publisher;
    private String genre;
    private Date publication_date;
    private String type;

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", genre='" + genre + '\'' +
                ", publication_date=" + publication_date +
                ", type='" + type + '\'' +
                ", id=" + id +
                '}';
    }
}
