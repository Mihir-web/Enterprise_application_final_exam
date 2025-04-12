package com.mh.spring.finalex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mh.spring.finalex.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
