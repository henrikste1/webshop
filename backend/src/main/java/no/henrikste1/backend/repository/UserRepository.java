package no.henrikste1.backend.repository;

import no.henrikste1.backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
