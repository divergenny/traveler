package by.divergenny.traveler.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TripDto {
    private String id;
    private String userId;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private String country;
    private String city;
    private int budget;
    private List<String> expenses;
    private Boolean lookingForATravelingCompanion = false;
}
