package com.example.healthUpdateProducer.repository;

import com.example.healthUpdateProducer.model.CustomerHealthPlans;
import com.example.healthUpdateProducer.model.HealthPlans;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HealthPlansRepository extends MongoRepository<HealthPlans, Integer> {
}
