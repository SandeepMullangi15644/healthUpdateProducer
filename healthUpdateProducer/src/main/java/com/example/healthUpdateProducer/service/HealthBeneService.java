package com.example.healthUpdateProducer.service;

import com.example.healthUpdateProducer.model.CustomerHealthPlans;
import com.example.healthUpdateProducer.model.Customers;
import com.example.healthUpdateProducer.model.HealthPlans;
import com.example.healthUpdateProducer.repository.CustomerHealthPlansRepository;
import com.example.healthUpdateProducer.repository.CustomerRepository;
import com.example.healthUpdateProducer.repository.HealthPlansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HealthBeneService {
    @Autowired
    CustomerRepository cust_repo;

    @Autowired
    CustomerHealthPlansRepository cust_health_repo;

    @Autowired
    HealthPlansRepository health_plan_repo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Customers> getCustomerData() {
        return cust_repo.findAll();
    }
    public Customers getCustomerByEmail(String email){
        return cust_repo.findByEmail(email).orElse(null);
    }

    public List<HealthPlans> getHealthPlanData() {
        return health_plan_repo.findAll();
    }

    public List<CustomerHealthPlans> getCustHealthPlanData() {
        return cust_health_repo.findAll();
    }


    public List<CustomerHealthPlans> getCustHealthPlansByCustomerId(Integer customerId) {
        return cust_health_repo.getByCustomerId(customerId);
    }
    public List<HealthPlans> getHealthPlansByIds(String ids) {
        String[] str = ids.split(",");
        List<Integer> intList = Arrays.stream(str).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").in(intList));
            return mongoTemplate.find(query, HealthPlans.class, "health_plans");
    }


}