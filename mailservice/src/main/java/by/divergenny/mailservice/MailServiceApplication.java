package by.divergenny.mailservice;

import by.divergenny.mailservice.configuration.MailSettingProperties;
import by.divergenny.mailservice.dto.MailDto;
import by.divergenny.mailservice.service.EmailService;
import by.divergenny.mailservice.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(MailServiceApplication.class, args);
        //MailSettingProperties mailSettingProperties = new MailSettingProperties();
       //EmailService emailService = new EmailServiceImpl(mailSettingProperties);
        //emailService.sendMail(mailDto);
    }

}
