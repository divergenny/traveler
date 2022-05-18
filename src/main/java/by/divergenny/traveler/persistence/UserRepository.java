package by.divergenny.traveler.persistence;

import by.divergenny.traveler.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    User findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User getById(String userId);

    List<User> getAllUsers();

    List<User> getByCountry(String country);

    List<User> getByCity(String city);

    void addUser(User user);

    void editUser(String userId, User user);

    void deleteUserById(String userId);
}
