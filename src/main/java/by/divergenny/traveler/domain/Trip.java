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
public class Trip {
    private String id;
    private String userid;
    private Date datestart;
    private Date dateend;
    private String country;
    private String city;
    private int budget;
    private List<String> expenses;
    private Boolean lookingForATravelingCompanion = false;
}
