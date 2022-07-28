package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.OrderNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.OrderDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Order;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final BuyerService buyerService;
    private final ItemService itemService;

    public OrderService(OrderRepository repository, BuyerService buyerService, ItemService itemService) {
        this.orderRepository = repository;
        this.buyerService = buyerService;
        this.itemService = itemService;
    }

    public void addItemToOrderList(Long orderId, Long itemId) {
        var itemById = itemService.findItemById(itemId);
        var orderById = findOrderById(orderId);

        orderById.ifPresent(order -> {
            var items = order.getItems();
            var item = itemById.get();
            items.add(item);
            order.setItems(items);
            orderRepository.save(order);
        });
    }

    protected Optional<Order> findOrderById(Long id) {
        var order = orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException("Related order with id: " + id + " not found"));
        return Optional.of(order);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }


}
