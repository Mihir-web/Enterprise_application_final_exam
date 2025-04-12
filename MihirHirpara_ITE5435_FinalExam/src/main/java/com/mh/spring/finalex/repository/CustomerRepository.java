package com.mh.spring.finalex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mh.spring.finalex.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
