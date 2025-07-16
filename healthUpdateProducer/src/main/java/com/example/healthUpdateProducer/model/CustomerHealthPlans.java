package com.example.healthUpdateProducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customer_health_plan")
public class CustomerHealthPlans {
    @Id
    private Integer id;
    private Integer customerId;
    private Integer planId;
    private String enrollmentDate;
    private String status;

}
