package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.controller;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
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

    @GetMapping("/all")
    public ResponseEntity<List<BuyerDTO>> getAllBuyers() {
        return new ResponseEntity(buyerService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BuyerDTO> getBuyerById(@PathVariable long id) {
        return ResponseEntity.ok(buyerService.getCustomerById(id));
    }

    @PostMapping("/create")
    //Raw use warning
    public ResponseEntity createBuyer(@RequestBody BuyerDTO buyerDTO) {
        buyerService.createBuyer(buyerDTO);
//        if (buyer == null) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Buyer could not be created");
//        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
