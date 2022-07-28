package cvut.fel.repository;

import cvut.fel.entity.PublishingHouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublishingHouseRepository extends CrudRepository<PublishingHouse, Long> {
    List<PublishingHouse> findByName(String name);
}
