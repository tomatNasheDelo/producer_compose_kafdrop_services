package com.github.pedroluiznogueira.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pedroluiznogueira.producer.ProducerApplication;
import com.github.pedroluiznogueira.producer.domain.FoodOrder;
import com.github.pedroluiznogueira.producer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class FoodOrderService {

    private final Producer producer;
    private static final Logger logger = LoggerFactory.getLogger(ProducerApplication.class);


    @Autowired
    public FoodOrderService(Producer producer) {
        this.producer = producer;
        logger.info("Rabota servisa++++");
    }

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
    	 logger.info("Eto create FoodOrder ix Service "+foodOrder);
        return producer.sendMessage(foodOrder);
    }
}
