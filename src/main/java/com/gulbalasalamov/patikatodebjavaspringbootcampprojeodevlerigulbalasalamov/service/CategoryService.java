package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.CategoryNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.CategoryDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Category;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ItemService itemService;

    public CategoryService(CategoryRepository categoryRepository, ItemService itemService) {
        this.categoryRepository = categoryRepository;
        this.itemService = itemService;
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

    public void deleteCategory(CategoryDTO categoryDTO) {
        var categoryById = findCategoryById(categoryDTO.getCategoryId());
        categoryById.ifPresent(categoryRepository::delete);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public void addItemToCategoryList(Long itemId, Long categoryId) {
        var itemById = itemService.findItemById(itemId);
        var categoryById = findCategoryById(categoryId);

        categoryById.ifPresent(category -> {
            var items = category.getItems();
            var item = itemById.get();
            items.add(item);
            category.setItems(items);
            categoryRepository.save(category);
        });
    }
}
