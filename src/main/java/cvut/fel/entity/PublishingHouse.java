package cvut.fel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class PublishingHouse extends AbstractEntity {
    private String name;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.MERGE})
    @JoinColumn(name = "author_id")
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.MERGE})
    @JoinColumn(name = "book_id")
    private Set<Book> published_books = new HashSet<>();

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public void addPublishedBook(Book book){
        this.published_books.add(book);
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", authors=" + authors +
                ", published_books=" + published_books +
                ", id=" + id +
                '}';
    }
}
