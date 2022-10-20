package com.mub.roomwebdemospring2essential.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mub.roomwebdemospring2essential.asyc.Payload;
import com.mub.roomwebdemospring2essential.config.MessagingConfig;
import com.mub.roomwebdemospring2essential.models.User;
import com.mub.roomwebdemospring2essential.repositories.UserRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppStartEvent implements ApplicationListener<ApplicationReadyEvent> {
    private UserRepository userRepository;
    private ObjectMapper mapper;
    private RabbitTemplate rabbitTemplate;

    public AppStartEvent(UserRepository userRepository, ObjectMapper mapper, RabbitTemplate rabbitTemplate) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.rabbitTemplate = rabbitTemplate;

    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        List<User> user = this.userRepository.findAll();
        user.forEach(System.out::println);
        try {
            rabbitTemplate.convertAndSend(MessagingConfig.TOPIC_KEY, MessagingConfig.ROUTING_KEY, mapper.writeValueAsString(new Payload(200, "ahmed")));
        } catch (JsonProcessingException e) {

        }
    }

}

