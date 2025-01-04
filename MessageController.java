package com.javatodev.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatodev.app.dto.User;
import com.javatodev.app.publisher.RabbitMQJsonProducer;
import com.javatodev.app.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer rabbitMQProducer;

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer, RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }


    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ.");
    }


    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ.");
    }
}
