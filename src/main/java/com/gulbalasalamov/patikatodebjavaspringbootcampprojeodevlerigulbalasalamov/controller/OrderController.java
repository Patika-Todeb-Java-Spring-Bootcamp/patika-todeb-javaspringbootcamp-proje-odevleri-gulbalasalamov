package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.controller;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.OrderDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        return new ResponseEntity(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return new ResponseEntity(orderService.getAllOrders(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDTO){
        orderService.addOrder(orderDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Long id,@RequestBody OrderDTO orderDTO){
        orderService.updateOrder(id,orderDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
