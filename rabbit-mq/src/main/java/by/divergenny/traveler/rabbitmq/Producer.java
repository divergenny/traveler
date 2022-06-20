package by.divergenny.traveler.rabbitmq;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class Producer {

    private RabbitTemplate template;


    // instead of string it can be any type of message
    public String sendMessage(String routingKey, String message) {
        this.template.convertAndSend(routingKey, message);
        return"message has been sent: "+ message;
        //System.out.println();
    }
}