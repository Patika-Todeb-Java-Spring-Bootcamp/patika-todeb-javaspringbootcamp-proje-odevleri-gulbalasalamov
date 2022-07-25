package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.BuyerNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.BuyerMapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.BuyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public BuyerDTO getBuyerById(Long id) {
        return BuyerMapper.toDto(
                buyerRepository.findById(id).orElseThrow(() ->
                        new BuyerNotFoundException("Related buyer with id : " + id + "not found"))
        );
    }

    public List<BuyerDTO> getAllOrders() {
        return buyerRepository.findAll()
                .stream()
                .map(BuyerMapper::toDto)
                .collect(Collectors.toList());
    }

    public void createBuyer(BuyerDTO buyerDTO) {
        Buyer buyer = BuyerMapper.toEntity(buyerDTO);
        buyerRepository.save(buyer);
    }

    public void updateBuyer(Long id, BuyerDTO buyerDTO) {
        BuyerDTO buyerDTO1 = getAllOrders().stream()
                .filter(b -> b.getBuyerId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BuyerNotFoundException("Couldn't update. Buyer with id: " + id + " not found"));

//        Optional<Buyer> buyerById = buyerRepository.findById(id);
//        Buyer buyer = buyerById.get();
//        if (!buyerById.isPresent()) {
//            return null;
//        }
        buyerDTO1.setFirstName(buyerDTO.getFirstName());
        buyerDTO1.setLastName(buyerDTO.getLastName());
        buyerDTO1.setEmail(buyerDTO.getEmail());
        buyerDTO1.setPhoneNumber(buyerDTO.getPhoneNumber());
        buyerDTO1.setActive(buyerDTO.isActive());
        Buyer buyer = BuyerMapper.toEntity(buyerDTO1);
        buyerRepository.save(buyer);
    }
    public void deleteBuyer(Long id) {
        Buyer buyer = buyerRepository.findById(id).orElseThrow(() -> new BuyerNotFoundException("Related buyer with id : " + id + "not found"));
        buyerRepository.delete(buyer);
    }
}
