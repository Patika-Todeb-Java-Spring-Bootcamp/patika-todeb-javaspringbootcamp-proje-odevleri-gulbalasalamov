package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.CategoryDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.ItemDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.OrderDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Category;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Order;

public class Mapper {
    public static BuyerDTO toDto(Buyer buyer) {
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setBuyerId(buyer.getBuyerId());
        buyerDTO.setFirstName(buyer.getFirstName());
        buyerDTO.setLastName(buyer.getLastName());
        buyerDTO.setEmail(buyer.getEmail());
//        buyerDTO.setActive(buyer.isActive());
        return buyerDTO;
        //return new BuyerDTO(buyer.getBuyerId(), buyer.getFirstName(), buyer.getLastName(), buyer.getEmail(), buyer.getPhoneNumber());
    }

    public static Buyer toEntity(BuyerDTO buyerDTO) {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(buyerDTO.getBuyerId());
        buyer.setFirstName(buyerDTO.getFirstName());
        buyer.setLastName(buyerDTO.getLastName());
        buyer.setEmail(buyerDTO.getEmail());
//        buyer.setActive(buyerDTO.isActive());
        return buyer;

        //return new Buyer(buyerDTO.getBuyerId(), buyerDTO.getFirstName(), buyerDTO.getLastName(), buyerDTO.getEmail(), buyerDTO.getPhoneNumber(),null,0,false,null);
    }

    public static ItemDTO toDto (Item item){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemId(item.getItemId());
        itemDTO.setName(item.getName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

    public static Item toEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemId(itemDTO.getItemId());
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        return item;
    }

    public static OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setConfirmed(order.isConfirmed());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setItems(order.getItems());
        return orderDTO;
    }

    public static Order toEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setConfirmed(orderDTO.isConfirmed());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setItems(orderDTO.getItems());
        return order;
    }

    public static CategoryDTO toDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryType(category.getCategoryType());
        //categoryDTO.setItems(category.getItems());
        return categoryDTO;
    }

    public static Category toEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId());
        category.setCategoryType(categoryDTO.getCategoryType());
        //category.setItems(categoryDTO.getItems());
        return category;
    }
}
