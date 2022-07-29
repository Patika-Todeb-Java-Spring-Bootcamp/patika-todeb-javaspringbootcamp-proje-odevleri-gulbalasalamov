package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "order_date")
    private Date dateOrdered;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Item> items;

    private double totalPrice;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    //@JoinColumn(name = "order_id")
//    private Buyer buyer;

//    public Order(Date dateOrdered, boolean isConfirmed, List<Item> items, double totalPrice) {
//        this.dateOrdered = dateOrdered;
//        this.isConfirmed = isConfirmed;
//        this.items = items;
//        this.totalPrice = totalPrice;
//    }
    //TODO: move to service
//    public void addItemToOrder(Item item){
//        items.add(item);
//    }
//
//    public void removeItemFromOrder(Item item) {
//        items.remove(item);
//    }
//}
}