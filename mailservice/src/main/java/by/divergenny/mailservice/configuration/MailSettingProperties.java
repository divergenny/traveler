package by.divergenny.mailservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class MailSettingProperties {
    public String hostName = "mail.smtp.host";
    private String portName = "mail.smtp.port";
    private String authName = "mail.smtp.auth";
    private String starttlsName = "mail.smtp.starttls.enable";
    private String checkServerIdentityName = "mail.smtps.ssl.checkserveridentity";
    private String trustName = "mail.smtps.ssl.trust";
    private String enableName = "mail.smtp.ssl.enable";

    @Value("${notification.mail.username}")
    private String usernameOfMailFromSend;

    @Value("${notification.mail.password}")
    private String passwordOfMailFormSend;

    @Value("${notification.mail.host}")
    private String hostValue;

    @Value("${notification.mail.port}")
    private int portValue;

    @Value("${notification.mail.auth}")
    private String authValue;

    @Value("${notification.mail.starttls}")
    private String starttlsValue;

    @Value("${notification.mail.checkServerIdentity}")
    private String checkServerIdentityValue;

    @Value("${notification.mail.trust}")
    private String trustValue;

    @Value("${notification.mail.enable}")
    private String enableValue;

}
