package by.divergenny.mailservice.web;

import by.divergenny.mailservice.dto.MailDto;
import by.divergenny.mailservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class MailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public boolean sendEmail(@RequestBody MailDto mailDto) {
        emailService.sendMail(mailDto);
        return true;
    }

}
