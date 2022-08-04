package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "category") // this will give entity name to database
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "category_id")
    private Long id;

    //    @ManyToMany
//    @JoinTable(
//            name = "item_categories",
//            joinColumns = @JoinColumn(name = "category_id"),
//            inverseJoinColumns = @JoinColumn(name = "item_id"))
     @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "categories")
    private Set<Item> items;

    private CategoryType categoryType;

    public void addCategoryToItem(Item item) {
        items.add(item);
    }

//    public Category(List<Item> items, CategoryType categoryType) {
//        this.items = items;
//        this.categoryType = categoryType;
//    }
}
