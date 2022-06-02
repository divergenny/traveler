package by.divergenny.traveler.service.impl;

import by.divergenny.traveler.domain.User;
import by.divergenny.traveler.persistence.UserRepository;
import by.divergenny.traveler.service.UserService;
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
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Another method to identify what will be return is:
     * Mockito.doReturn(Optional.of(user)).when(userRepo).findById(any());
     */
    @Test
    void deleteById() {
        User user = new User("1", "Vladimir", "Zhuk",
                Date.valueOf("2022-01-01"), "zhuk@gmail.com",
                "Poland", "Warsaw", "Dream trip");
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        User deletedUser = userService.deleteById("1");
        Assertions.assertEquals(user, deletedUser);
    }
}
