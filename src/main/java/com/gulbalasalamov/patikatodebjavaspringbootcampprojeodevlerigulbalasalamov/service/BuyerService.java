package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.BuyerNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.BuyerRepository;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;
    private final OrderRepository orderRepository;

    public BuyerService(BuyerRepository buyerRepository,OrderRepository orderRepository) {
        this.buyerRepository = buyerRepository;
        this.orderRepository = orderRepository;
    }

    protected Optional<Buyer> findBuyerById(Long id) {
        var buyer = buyerRepository.findById(id).orElseThrow(() ->
                new BuyerNotFoundException("Related buyer with id : " + id + " not found"));
        return Optional.of(buyer);
    }

    public BuyerDTO getBuyerById(Long id) {
        var buyerById = findBuyerById(id);
        return Mapper.toDto(buyerById.get());
    }

    public List<BuyerDTO> getAllBuyers() {
        return buyerRepository.findAll()
                .stream()
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public void addBuyer(BuyerDTO buyerDTO) {
        buyerRepository.save(Mapper.toEntity(buyerDTO));
    }

    public void updateBuyer(Long id, BuyerDTO buyerDTO) {

        var buyerOptional = findBuyerById(id);
        buyerOptional.ifPresent(buyer -> {
            buyer.setId(buyerDTO.getBuyerId());
            buyer.setFirstName(buyerDTO.getFirstName());
            buyer.setLastName(buyerDTO.getLastName());
            buyer.setEmail(buyerDTO.getEmail());
            buyer.setPhoneNumber(buyerDTO.getPhoneNumber());
            buyerRepository.save(buyer);
        });
    }

    public void deleteBuyer(Long id) {
       var buyerById = findBuyerById(id);
        buyerById.ifPresent(buyerRepository::delete);
    }

}
