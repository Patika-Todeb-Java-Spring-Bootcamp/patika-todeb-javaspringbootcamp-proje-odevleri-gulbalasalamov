package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class BuyerDTO {
    private String firstName;
    private String lastName;
    private List<Order> orders;
}
