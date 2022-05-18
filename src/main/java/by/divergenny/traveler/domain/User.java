package by.divergenny.traveler.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	public String id;
	public String firstName;
	public String lastName;
	public Date dateOfBirth;
	public String country;
	public String city;
	public String about;

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}