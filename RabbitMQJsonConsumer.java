package com.javatodev.app.consumer;

import com.javatodev.app.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        log.info(String.format("Received json message -> %s", user.toString()));
    }
}
