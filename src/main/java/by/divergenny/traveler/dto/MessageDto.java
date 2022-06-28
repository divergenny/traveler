package by.divergenny.traveler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String username;
    private String email;
    private String message;
    private String country;
    private LocalDate dateFrom;
    private LocalDate dateTo;
}
