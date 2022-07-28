package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Category;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.CategoryType;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private Long categoryId;
    private CategoryType categoryType;
    //private List<Item> items;
}
