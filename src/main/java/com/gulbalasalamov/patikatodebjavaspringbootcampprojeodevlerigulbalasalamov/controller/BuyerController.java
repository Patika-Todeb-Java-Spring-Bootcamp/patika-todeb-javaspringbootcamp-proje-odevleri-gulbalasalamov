package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.controller;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service.BuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/buyer")
public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping
    public String welcome(){
        return "Hello. This is BuyerService speaking :=)";
    }

    @GetMapping("/all")
    public ResponseEntity<List<BuyerDTO>> getAllBuyers() {
        return new ResponseEntity(buyerService.getAllBuyers(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BuyerDTO> getBuyerById(@PathVariable long id) {
        BuyerDTO buyerById = buyerService.getBuyerById(id);
        //return ResponseEntity.status(HttpStatus.OK).body(buyerById);
        return new ResponseEntity(buyerById,HttpStatus.OK);
    }

    @PostMapping("/add")
    //Raw use warning
    public ResponseEntity addBuyer(@RequestBody BuyerDTO buyerDTO) {
        buyerService.addBuyer(buyerDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateBuyer(@PathVariable Long id, @RequestBody BuyerDTO buyerDTO) {
        buyerService.updateBuyer(id, buyerDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PatchMapping("/{id}")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
        //return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.OK).body("Related buyer was deleted successfully");
    }
}
