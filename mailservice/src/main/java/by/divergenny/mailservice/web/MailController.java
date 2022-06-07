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

    @PostMapping("/email/{email}")
    public boolean sendEmail(String email) {
        MailDto mailDto = new MailDto(email,
                "TestEmailToYou",
                "Well done! :)");
        emailService.sendMail(mailDto);
        return true;
    }

}
