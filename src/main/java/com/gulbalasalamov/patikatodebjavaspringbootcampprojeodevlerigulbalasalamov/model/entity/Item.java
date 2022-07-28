package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item") // this will give entity name to database

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;

    private String name;
    private String description;
    private double price;
    private Integer stock;

//    public Item(String name, String description, double price, Integer stock) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.stock = stock;
//    }
}