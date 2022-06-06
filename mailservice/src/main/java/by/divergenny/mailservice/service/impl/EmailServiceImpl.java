package by.divergenny.mailservice.service.impl;

import by.divergenny.mailservice.configuration.MailSettingProperties;
import by.divergenny.mailservice.dto.MailDto;
import by.divergenny.mailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final MailSettingProperties mailProperties;

    @Async
    public void sendMail(MailDto mailDto) {
        try {
            log.info("Send email called.");
            String email = mailDto.getEmail();
            Properties properties = setSettingsOfProperties();

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailProperties.getUsernameOfMailFromSend(),
                            mailProperties.getPasswordOfMailFormSend());
                }
            };
            Session session = Session.getInstance(properties, auth);

            Message message = prepareMessage(session, email, mailDto);
            Transport.send(message);
            log.info("Successfully send to recipient.");
        } catch (Exception e) {
            log.error("Error during sending of email.", e);
        }
    }

    private Message prepareMessage(Session session, String email, MailDto mailDto) {
        Message message = null;
        session.setDebug(true);
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailProperties.getUsernameOfMailFromSend()));
            message.setRecipients(
                    Message.RecipientType.TO,
                    new InternetAddress[]{new InternetAddress(email)}
            );
            message.setSubject(mailDto.getHeader());
            message.setText(mailDto.getBody());

            log.info("Email to: {}, with title: {}", email, mailDto.getHeader());
        } catch (MessagingException e) {
            log.error("Error by preparing message. ", e);
        }
        return message;
    }

    private Properties setSettingsOfProperties() {
        Properties properties = new Properties();
        properties.put(mailProperties.getHostName(), mailProperties.getHostValue());
        properties.put(mailProperties.getPortName(), mailProperties.getPortValue());
        properties.put(mailProperties.getAuthName(), mailProperties.getAuthValue());
        properties.put(mailProperties.getStarttlsName(), mailProperties.getStarttlsValue());
        properties.put(mailProperties.getCheckServerIdentityName(), mailProperties.getCheckServerIdentityValue());
        properties.put(mailProperties.getTrustName(), mailProperties.getTrustValue());
        properties.put(mailProperties.getEnableName(), mailProperties.getEnableValue());
        return properties;
    }
}
