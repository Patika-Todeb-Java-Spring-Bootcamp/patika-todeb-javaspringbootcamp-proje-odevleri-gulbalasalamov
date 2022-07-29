package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item") // this will give entity name to database

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "item_id")
    private Long id;

    private String name;
    private String description;
    private double price;
    private Integer stock;

    @JsonIgnore
    @ManyToMany(mappedBy = )
    private List<Category> categories;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Order order;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private Seller seller;




//    public Item(String name, String description, double price, Integer stock) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.stock = stock;
//    }
}