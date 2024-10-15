package com.eventapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "eventdata")
@Entity
public class EventRegistration {
    @Id
    private String id;
    private String eventName;
    private String dateTime;
    private String address;
    private String organizerName;
    private String phone;
    private String email;
    private String ticketType;
    private double ticketPrice;
    private int ticketQuantity;
    private double totalPrice;
    private String paymentMethod;
}
