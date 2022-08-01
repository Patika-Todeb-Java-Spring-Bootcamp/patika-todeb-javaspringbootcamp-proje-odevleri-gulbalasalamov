package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.ItemNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.ItemDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Category;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Order;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.CategoryRepository;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.ItemRepository;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.OrderRepository;
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
            item.getCategories().add(category);
            item.setCategories(item.getCategories());
            //item.addItemToCategory(categoryById.get());
            itemRepository.save(item);
        });
    }

//    public void addItemToOrder(Long itemId,Long orderId) {
//        var orderByID = orderRepository.findById(itemId);
//        var itemById = findItemById(orderId);
//
//        itemById.ifPresent(item -> {
//            Order order = orderByID.get();
//            item..add(order);
//            items.add(item);
//            order.setItems(items);
//           // item.setOrder(order);
////            order.getItems().add(itemById.get());
////            var items = order.getItems();
////            var item = itemById.get();
////            items.add(item);
////            order.setItems(items);
//            orderRepository.save(order);
//        });
//    }

//    public void removeItemToOrder(Long orderId, Long itemId) {
//        var itemById = itemRepository.findById(itemId);
//        var orderById = findOrderById(orderId);
//
//        orderById.ifPresent(order -> {
//            order.removeItemFromOrder(itemById.get());
//            orderRepository.save(order);
//        });
//    }


}
