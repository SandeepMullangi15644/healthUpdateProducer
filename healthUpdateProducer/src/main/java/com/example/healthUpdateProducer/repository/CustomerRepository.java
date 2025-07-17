package com.example.healthUpdateProducer.repository;

import com.example.healthUpdateProducer.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customers, String> {
    Optional<Customers> findByEmail(String email);
}
