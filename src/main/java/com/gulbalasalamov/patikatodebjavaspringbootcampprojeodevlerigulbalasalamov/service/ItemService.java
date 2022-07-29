package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.ItemNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.ItemDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Category;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.CategoryRepository;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    protected Optional<Item> findItemById(Long id) {
        var item = itemRepository.findById(id).orElseThrow(() ->
                new ItemNotFoundException("Related item with id: " + id + " not found"));
        return Optional.of(item);
    }

    public ItemDTO getItemById(Long id) {
        var itemById = findItemById(id);
        return Mapper.toDto(itemById.get());
    }

    public void addItem(ItemDTO itemDTO) {
        itemRepository.save(Mapper.toEntity(itemDTO));
    }


    public void deleteItem(Long id) {
        var itemById = findItemById(id);
        itemById.ifPresent(itemRepository::delete);
    }

    public List<ItemDTO> getAllItems() {
        return itemRepository.findAll().stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateItem(Long id, ItemDTO itemDTO) {
        var itemById = findItemById(id);
        itemById.ifPresent(item -> {
            item.setId(itemDTO.getItemId());
            item.setName(itemDTO.getName());
            item.setDescription(itemDTO.getDescription());
            item.setPrice(itemDTO.getPrice());
            itemRepository.save(item);
        });
    }

    public void addItemToCategory(Long itemId, Long categoryId) {
        Optional<Item> itemById = findItemById(itemId);
        Optional<Category> categoryById = categoryRepository.findById(categoryId);

        itemById.ifPresent(item -> {
            Category category = categoryById.get();
            Set<Category> categories = item.getCategories();
            categories.add(category);
            item.setCategories(categories);
            //item.addItemToCategory(categoryById.get());
            itemRepository.save(item);
        });
    }


//    private Optional<Buyer> findBuyerById(Long id) {
//        Buyer buyer = buyerRepository.findById(id).orElseThrow(() ->
//                new BuyerNotFoundException("Related buyer with id : " + id + " not found"));
//        return Optional.of(buyer);
//    }


}
