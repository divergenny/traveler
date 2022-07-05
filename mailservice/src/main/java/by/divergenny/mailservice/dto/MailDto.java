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

    public void putTextAndLink(String botUsername){
        this.body = String.format(
                """
                        Hello!\s
                        This email was sent to verify your account
                        Please follow the link below to verify it:
                        https://t.me/%s?start=%s""",
                botUsername,
                this.link
        );
    }

    public void putTextAndLink(MessageDto messageDto){
        this.body = String.format(
                """
                        Dear %s! \s
                        This email was sent to verify your Trip to %s.
                        Your Trip set from %s date, to %s date,
                        Please follow the link below to verify it:
                        https://t.me/%s?start=%s""",
                messageDto.getUsername(),
                messageDto.getCountry(),
                messageDto.getDateFrom(),
                messageDto.getDateTo(),
                messageDto.getUsername(),
                this.link
        );
    }
}
