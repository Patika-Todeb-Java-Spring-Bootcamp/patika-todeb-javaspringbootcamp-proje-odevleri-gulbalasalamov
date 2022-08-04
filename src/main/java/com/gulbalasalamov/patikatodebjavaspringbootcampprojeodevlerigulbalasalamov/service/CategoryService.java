package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.CategoryNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.CategoryDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Category;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.CategoryRepository;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;

    public CategoryService(CategoryRepository categoryRepository, ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
    }

    protected Optional<Category> findCategoryById(Long id) {
        var category = categoryRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException("Related category with id: " + id + " not found"));
        return Optional.of(category);
    }

    public CategoryDTO getCategoryById(Long id) {
        var categoryById = findCategoryById(id);
        return Mapper.toDto(categoryById.get());
    }

    public void createCategory(CategoryDTO categoryDTO) {
        categoryRepository.save(Mapper.toEntity(categoryDTO));
    }

    public void deleteCategory(Long id) {
        var categoryById = findCategoryById(id);
        categoryById.ifPresent(categoryRepository::delete);
    }

    public void updateCategory(Long categoryId, CategoryDTO categoryDTO) {
        var categoryById = findCategoryById(categoryId);
        categoryById.ifPresent(category -> {
            category.setId(categoryDTO.getCategoryId());
            category.setCategoryType(categoryDTO.getCategoryType());
            categoryRepository.save(category);
        });
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public void addCategoryToItem(Long categoryId,Long itemId) {
        var categoryById = findCategoryById(categoryId);
        var itemById = itemRepository.findById(itemId);

        categoryById.ifPresent(category -> {
            Item item = itemById.get();
            category.getItems().add(item);
            category.setItems(category.getItems());
            categoryRepository.save(category);
        });
    }
}
