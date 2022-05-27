package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.mapper.UserMapper;
import by.divergenny.traveler.persistence.UserRepository;
import by.divergenny.traveler.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    @Override
    public List<User> findByFirstName(String firstName) {
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
        return userRepository.findAll();
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
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editUser(String userId, User userWithNewData) {
        User userInSystem = userRepository.findById(userId).orElse(null);
        if (null == userInSystem) {
            return null;
        }
        checkAndSet(userInSystem, userWithNewData);
        userRepository.save(userInSystem);
        return userInSystem;
    }

    private void checkAndSet(User userInSystem, User userWithNewData) {
        if (null != userWithNewData.getFirstName()
                && !userWithNewData.getFirstName().isEmpty()
                && !userInSystem.getFirstName().equals(userWithNewData.getFirstName())
        ) {
            userInSystem.setFirstName(userWithNewData.getFirstName());
        }
        if (null != userWithNewData.getLastName()
                && !userWithNewData.getLastName().isEmpty()
                && !userInSystem.getLastName().equals(userWithNewData.getLastName())
        ) {
            userInSystem.setLastName(userWithNewData.getLastName());
        }
        if (null != userWithNewData.getDateOfBirth()
                && !userInSystem.getDateOfBirth().equals(userWithNewData.getDateOfBirth())
        ) {
            userInSystem.setDateOfBirth(userWithNewData.getDateOfBirth());
        }
        if (null != userWithNewData.getCountry()
                && !userWithNewData.getCountry().isEmpty()
                && !userInSystem.getCountry().equals(userWithNewData.getCountry())
        ) {
            userInSystem.setCountry(userWithNewData.getCountry());
        }
        if (null != userWithNewData.getCity()
                && !userWithNewData.getCity().isEmpty()
                && !userInSystem.getCity().equals(userWithNewData.getCity())
        ) {
            userInSystem.setCity(userWithNewData.getCity());
        }
        if (null != userWithNewData.getAbout()
                && !userInSystem.getAbout().equals(userWithNewData.getAbout())
        ) {
            userInSystem.setAbout(userWithNewData.getAbout());
        }
    }

    @Override
    public User deleteById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        userRepository.deleteUserById(userId);
        return user.get();
    }
}
