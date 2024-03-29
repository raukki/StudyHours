package studyhours.backend.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface entryRepository extends CrudRepository<entry, Long> {
    List<entry> findByentrydate(String entrydate);   
}
