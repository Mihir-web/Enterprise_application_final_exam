package com.mh.spring.finalex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mh.spring.finalex.model.Reservation;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}
