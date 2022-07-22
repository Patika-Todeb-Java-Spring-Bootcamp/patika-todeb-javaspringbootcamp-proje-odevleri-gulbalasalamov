package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "item") // this will give entity name to database

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long itemId;
    private String name;
    private int quantity;

    @NotNull
    @ManyToMany(mappedBy = "items",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Seller> sellers;

    @NotNull
    @ManyToMany(mappedBy = "items",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Order> orders;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Category category;
}
