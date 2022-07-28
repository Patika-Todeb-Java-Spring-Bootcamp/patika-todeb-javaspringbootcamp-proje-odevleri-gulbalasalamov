package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Long orderId;
    private boolean isConfirmed;
    private List<Item> items;
    private double totalPrice;

}
