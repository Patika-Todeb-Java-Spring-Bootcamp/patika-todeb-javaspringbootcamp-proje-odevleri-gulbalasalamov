package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private double price;
    private Integer stock;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "item_categories",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    //https://stackoverflow.com/questions/40266770/spring-jpa-bi-directional-cannot-evaluate-tostring
    @Override
    public String toString() {
        return "";
    }
}