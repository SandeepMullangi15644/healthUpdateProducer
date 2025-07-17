package com.example.healthUpdateProducer.repository;

import com.example.healthUpdateProducer.model.CustomerHealthPlans;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface CustomerHealthPlansRepository extends MongoRepository<CustomerHealthPlans, String> {

    @Query("{ 'customer_id' : ?0 }")
    List<CustomerHealthPlans> getByCustomerId(Integer customerId);

}
