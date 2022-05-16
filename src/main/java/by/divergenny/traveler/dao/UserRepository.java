package by.divergenny.traveler.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import by.divergenny.traveler.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByFirstName(String firstName);
	List<User> findByLastName(String lastName);

}