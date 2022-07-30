package cvut.fel.repository;

import cvut.fel.entity.Library;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibraryRepository extends CrudRepository<Library, Long> {
    List<Library> findByName(String name);
}
