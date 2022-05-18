package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.persistence.UserRepository;
import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public User findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public User getById(String userId) {
        return userRepository.getById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getByCountry(String country) {
        return userRepository.getByCountry(country);
    }

    @Override
    public List<User> getByCity(String city) {
        return userRepository.getByCity(city);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void editUser(String userId, User user) {
        userRepository.editUser(userId, user);
    }

    @Override
    public void delete(String userId) {
        userRepository.deleteUserById(userId);
    }
}
