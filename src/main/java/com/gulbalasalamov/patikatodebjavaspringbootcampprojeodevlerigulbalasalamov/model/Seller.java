package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seller") // this will give entity name to database
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seller_id")
    private Long sellerId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "seller_item",
//            joinColumns = @JoinColumn(name = "seller_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id")
//    )
    @ManyToMany(mappedBy = "seller",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Message> messages;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;


}
