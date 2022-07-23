package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buyer") // this will give entity name to database
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buyer_id")
    private Long buyerId;

    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private List<Order> orders;
}
