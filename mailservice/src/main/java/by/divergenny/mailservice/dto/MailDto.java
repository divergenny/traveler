package by.divergenny.mailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailDto {
    private String email;
    private String header;
    private String body;
    private String link;


    public MailDto(String email, String header, String body) {
        this.email = email;
        this.header = header;
        this.body = body;
    }
}
