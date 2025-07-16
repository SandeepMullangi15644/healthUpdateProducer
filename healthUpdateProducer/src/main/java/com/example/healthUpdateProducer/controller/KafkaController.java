package com.example.healthUpdateProducer.controller;

import com.example.healthUpdateProducer.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/healthplans")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public String publishHealthPlan(@RequestBody Map<String, Object> updatedFields) {
        kafkaProducer.sendHealthPlan(updatedFields);
        return "Health plan update sent to Kafka successfully!";
    }
}
