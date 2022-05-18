package by.divergenny.traveler.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.divergenny.traveler.persistence.UserRepository;
import by.divergenny.traveler.domain.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		return repository.findAll();
	}

	@PostMapping
	public User add(@RequestBody User user) {
		return repository.save(user);
	}
}
