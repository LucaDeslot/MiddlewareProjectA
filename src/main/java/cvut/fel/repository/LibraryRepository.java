package cvut.fel.repository;

import cvut.fel.entity.Library;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryRepository extends CrudRepository<Library, Long> {
    List<Library> findByName(String name);
}
