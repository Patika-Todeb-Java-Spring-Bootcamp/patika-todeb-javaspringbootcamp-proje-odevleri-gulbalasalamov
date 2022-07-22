package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "order") // this will give entity name to database
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id",updatable = false,nullable = false)
    private Long orderId;

    //TODO: Learn more about Java Date class implementation in db
    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "order_date",updatable = false,nullable = false)
    private Date date;

    @Column(name = "is_requested")
    private boolean isRequested;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @NotNull
    //TODO: why not null default msg is not allowed
    //@NotNull(message ="List item can not be null for order")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",referencedColumnName = "item_id")
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seller_id",referencedColumnName = "seller_id")
    private Seller seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id",referencedColumnName = "buyer_id")
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id", referencedColumnName = "shopping_cart_id")
    private ShoppingCart shoppingCart;



}
