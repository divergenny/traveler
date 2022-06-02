package by.divergenny.traveler.web;

import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findUsersByFirstName/{firstName}")
    public List<User> findUsersByFirstName(@PathVariable String firstName) {
        return userService.findByFirstName(firstName);
    }

    @GetMapping("findUsersByLastName/{lastName}")
    public List<User> findUsersByLastName(@PathVariable String lastName) {
        return userService.findByLastName(lastName);
    }

    @GetMapping("findUserById/{userId}")
    public User findUserById(@PathVariable String userId) {
        return userService.getById(userId);
    }

    @GetMapping("getAllUsers")
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @GetMapping("findUsersByCountry/{country}")
    public List<User> findUsersByCountry(@PathVariable String country) {
        return userService.getByCountry(country);
    }

    @GetMapping("findUsersByCountry/{city}")
    public List<User> findUsersByCity(@PathVariable String city) {
        return userService.getByCity(city);
    }

    @PostMapping("addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("editUser/{userId}")
    public User editUser(@PathVariable String userId, @RequestBody User user) {
        return userService.editUser(userId, user);
    }

    @DeleteMapping("deleteUserById/{userId}")
    public User deleteUserById(@PathVariable String userId) {
        return userService.deleteById(userId);
    }

}
