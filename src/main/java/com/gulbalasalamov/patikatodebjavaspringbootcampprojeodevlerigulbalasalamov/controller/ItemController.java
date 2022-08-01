package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.controller;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.ItemDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.ItemRepository;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service.ItemService;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping({"/get/{id}"})
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return new ResponseEntity(itemService.getItemById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemDTO>> getAllItems() {
        return new ResponseEntity(itemService.getAllItems(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        itemService.updateItem(id, itemDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{itemId}/category/{categoryId}")
    public ResponseEntity addItemToCategory(@PathVariable Long itemId, @PathVariable Long categoryId) {
        itemService.addItemToCategory(itemId,categoryId);
        return new ResponseEntity(HttpStatus.OK);
    }


}
