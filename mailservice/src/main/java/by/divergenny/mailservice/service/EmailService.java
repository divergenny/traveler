package by.divergenny.mailservice.service;


import by.divergenny.mailservice.dto.MailDto;

public interface EmailService {
    void sendMail(MailDto mailDto);
}
