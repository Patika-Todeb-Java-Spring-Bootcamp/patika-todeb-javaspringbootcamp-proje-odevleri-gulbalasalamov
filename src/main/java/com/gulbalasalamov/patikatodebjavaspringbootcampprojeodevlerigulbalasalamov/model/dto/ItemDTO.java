package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ItemDTO {
    private Long itemId;
    private String name;
    private String description;
    private double price;
}
