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
    private Long id;

    private String name;
    private String description;
    private double price;
    private Integer stock;
    //@JsonIgnore
    //@ManyToMany(mappedBy = "items")
    //private Set<Category> categories = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "item_categories",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    //    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private Seller seller;


    public void addItemToCategory(Category category) {
        categories.add(category);
    }

}