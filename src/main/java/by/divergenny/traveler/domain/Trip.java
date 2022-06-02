package by.divergenny.traveler.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Trip {
    private String id;
    private String userid;
    private Date dateStart;
    private Date dateEnd;
    private String country;
    private String city;
    private int budget;
    private List<String> expenses;
    private Boolean lookingForATravelingCompanion = false;
}
