package by.divergenny.traveler.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {
    @Autowired
    private Producer producer;

    @PostMapping("sendMessage")
    public String sendMessage(@RequestBody String message) {
        System.out.println("----------------------------------->" + message);
        return producer.sendMessage("queue-message", message);
    }

}
