package studyhours.backend.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface personRepository extends CrudRepository<person, Long> {
    List<person> findByName(String name);

}
