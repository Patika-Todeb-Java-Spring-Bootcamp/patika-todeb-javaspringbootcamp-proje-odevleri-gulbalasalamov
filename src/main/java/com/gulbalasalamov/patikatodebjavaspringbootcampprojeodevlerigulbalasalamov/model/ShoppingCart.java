package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "shopping_cart") // this will give entity name to database
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shopping_cart_id")
    private long shoppingCartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="buyer")
    private Buyer buyer;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;




}
