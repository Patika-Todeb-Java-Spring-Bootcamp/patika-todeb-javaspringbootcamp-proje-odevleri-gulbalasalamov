package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class OrderDTO {

    private Long orderId;
    private boolean isConfirmed;
    private List<Item> items;
    //private Set<Item> items;
    private double totalPrice;

}
