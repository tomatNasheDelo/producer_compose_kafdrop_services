package com.github.pedroluiznogueira.producer.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pedroluiznogueira.producer.domain.FoodOrder;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Producer {
	
	private Logger logger = Logger.getLogger(Producer.class.getName());

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(FoodOrder foodOrder) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
        kafkaTemplate.send(orderTopic, orderAsMessage);

        logger.info("food order produced {} "+orderAsMessage);

        return "message sent";
    }
}
