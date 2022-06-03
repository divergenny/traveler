package by.divergenny.mailservice.web;

import by.divergenny.mailservice.dto.MailDto;
import by.divergenny.mailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public boolean sendEmail() {
        MailDto mailDto = new MailDto("divergenny@gmail.com", "Hello", "Done", "123123123");
        emailService.sendMail(mailDto);
        return true;
    }


}
