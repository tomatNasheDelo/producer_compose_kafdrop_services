package com.github.pedroluiznogueira.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;


import com.github.pedroluiznogueira.producer.domain.FoodOrder;
import com.github.pedroluiznogueira.producer.service.FoodOrderService;
import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order")
public class FoodOrderController {
	
	private Logger logger = Logger.getLogger(FoodOrderController.class.getName());

    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        logger.info("create food order request received");
        return foodOrderService.createFoodOrder(foodOrder);
    }
}
