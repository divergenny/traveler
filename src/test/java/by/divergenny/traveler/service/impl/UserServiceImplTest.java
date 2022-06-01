package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.persistence.UserRepository;
import by.divergenny.traveler.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepo;

    @Test
    void deleteById() {
        User user = new User("1", "Vladimir", "Zhuk",
                Date.valueOf("2022-01-01"), "zhuk@gmail.com",
                "Poland", "Warsaw", "Dream trip");
        when(userRepo.findById(any())).thenReturn(Optional.of(user));
        //when(userRepo.deleteUserById(any())).thenAnswer(null);
        User deletedUser = userService.deleteById("1");
        System.out.println("1 _-------->"+ deletedUser);
        Assertions.assertEquals(user, deletedUser);
    }
}
