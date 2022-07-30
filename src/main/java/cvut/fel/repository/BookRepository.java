package cvut.fel.repository;

import cvut.fel.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);

}
