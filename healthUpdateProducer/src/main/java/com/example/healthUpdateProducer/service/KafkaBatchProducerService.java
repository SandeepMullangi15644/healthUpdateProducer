package com.example.healthUpdateProducer.service;

import com.example.healthUpdateProducer.model.HealthPlanBenefit;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaBatchProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "benefit-events";

    public void sendBatch() {
        try {
            InputStream is = new ClassPathResource("plans.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            List<HealthPlanBenefit> plans = mapper.readValue(is, new TypeReference<>() {});
            for (HealthPlanBenefit plan : plans) {
                kafkaTemplate.send(TOPIC, plan);
            }
            System.out.println("All plans sent to Kafka topic: " + TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

