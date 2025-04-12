package com.mh.spring.finalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer numberOfPassengers;
    private String seatClass;
    private String phoneNumber;
    private LocalDate dateOfDeparting;
    private String paymentId;
   

    public Reservation() {}

    public Reservation(String firstName, String lastName, Integer numberOfPassengers,
                       String seatClass, String phoneNumber, LocalDate dateOfDeparting,
                       String paymentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfPassengers = numberOfPassengers;
        this.seatClass = seatClass;
        this.phoneNumber = phoneNumber;
        this.dateOfDeparting = dateOfDeparting;
        this.paymentId = paymentId;
        
    }

    // Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public String getSeatClass() {
        return seatClass;
    }
    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getDateOfDeparting() {
        return dateOfDeparting;
    }
    public void setDateOfDeparting(LocalDate dateOfDeparting) {
        this.dateOfDeparting = dateOfDeparting;
    }
    public String getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
   
}
