package by.divergenny.traveler.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
    private String country;
    private String city;
    private String about;

}
