package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category") // this will give entity name to database
public class Category {

    public Category(Set<Item> items, CategoryType categoryType) {
        this.items = items;
        this.categoryType = categoryType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "category_id")
    private Long id;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Item> items;

    private CategoryType categoryType;

    //https://stackoverflow.com/questions/40266770/spring-jpa-bi-directional-cannot-evaluate-tostring
    @Override
    public String toString() {
        return "";//return empty string
    }
}
