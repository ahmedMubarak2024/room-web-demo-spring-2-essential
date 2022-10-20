package com.mub.roomwebdemospring2essential.asyc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    private static Logger logger = LoggerFactory.getLogger(MessageListener.class);
    private final ObjectMapper mapper;

    public MessageListener(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void handleMessage(String message) {
        try {
            Payload payload = mapper.readValue(message, Payload.class);
            logger.info("message Received id:{}, model:{}", payload.getId(), payload.getModel());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
