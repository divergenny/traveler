package by.divergenny.traveler.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "${todo.amqp.queue}")
    public void process(String message) {
        // some actions
        System.out.println("method received this message " + message);
    }
}