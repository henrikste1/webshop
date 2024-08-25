package no.henrikste1.backend.repository;

import no.henrikste1.backend.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
