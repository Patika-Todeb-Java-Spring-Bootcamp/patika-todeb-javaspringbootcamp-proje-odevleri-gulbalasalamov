package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category") // this will give entity name to database
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "category_id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "item_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    private CategoryType categoryType;

//    public Category(List<Item> items, CategoryType categoryType) {
//        this.items = items;
//        this.categoryType = categoryType;
//    }
}
