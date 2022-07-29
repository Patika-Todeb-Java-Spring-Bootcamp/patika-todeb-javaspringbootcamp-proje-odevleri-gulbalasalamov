package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders") // this will give entity name to database
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "order_id", nullable = false)
    private Long id;

    @CreationTimestamp
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "order_date")
    private Date dateOrdered;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    @JoinColumn(name = "order_id")
    private List<Item> items;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id",referencedColumnName = "id")
    private Buyer buyer;

    private double totalPrice;

    //TODO: move to service
//    public void addItemToOrder(Item item){
//        items.add(item);
//    }
//
//    public void removeItemFromOrder(Item item) {
//        items.remove(item);
//    }
//}
}