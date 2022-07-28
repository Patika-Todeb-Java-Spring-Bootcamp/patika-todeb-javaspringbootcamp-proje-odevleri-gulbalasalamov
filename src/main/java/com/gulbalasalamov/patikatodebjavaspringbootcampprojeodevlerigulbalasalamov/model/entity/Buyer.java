package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buyer_id")
    private Long buyerId;
    private String firstName;
    private String lastName;
    private String email;

    @Column(name = "password",length = 15)
    private String password;
    private String phoneNumber;
    private String address;
    private double balance;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private List<Order> orders;

//    public Buyer(String firstName,
//                 String lastName,
//                 String email,
//                 String phoneNumber,
//                 String address,
//                 double balance,
//                 boolean isActive,
//                 List<Order> orders) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.balance = balance;
//        this.isActive = isActive;
//        this.orders = orders;
//    }
    //TODO: move to service
    public void addOrder(Order order){
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
