package by.divergenny.traveler.persistence;

import by.divergenny.traveler.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User getById(String userId);

    List<User> getByCountry(String country);

    List<User> getByCity(String city);

    void deleteUserById(String userId);
}
