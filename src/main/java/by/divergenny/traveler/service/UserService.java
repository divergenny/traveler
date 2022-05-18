package by.divergenny.traveler.service;

import by.divergenny.traveler.domain.User;

import java.util.List;

public interface UserService {
    User findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User getById(String userId);

    List<User> getAllUsers();

    List<User> getByCountry(String country);

    List<User> getByCity(String city);

    void addUser(User user);

    void editUser(String userId, User user);

    void delete(String userId);
}
