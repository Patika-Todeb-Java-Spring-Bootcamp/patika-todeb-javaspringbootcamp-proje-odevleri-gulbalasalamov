package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders") // this will give entity name to database
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "order_id", nullable = false)
    private Long id;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "order_date")
    private Date dateOrdered;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    //    @JsonIgnore
//    @OneToMany(mappedBy = "order")

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<Item> items;

//    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    private Set<Item> orderItems;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private Buyer buyer;

    private double totalPrice;

    public void addItemToOrder(Item item) {
        items.add(item);
    }

    public void removeItemFromOrder(Item item) {
        items.remove(item);
    }
}