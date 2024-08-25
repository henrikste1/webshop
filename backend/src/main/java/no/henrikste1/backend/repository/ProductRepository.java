package no.henrikste1.backend.repository;

import no.henrikste1.backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
