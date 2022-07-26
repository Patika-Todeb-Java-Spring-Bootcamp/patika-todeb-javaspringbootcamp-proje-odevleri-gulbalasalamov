package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.exception.BuyerNotFoundException;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.BuyerMapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    protected Optional<Buyer> findBuyerById(Long id) {
        Buyer buyer = buyerRepository.findById(id).orElseThrow(() ->
                new BuyerNotFoundException("Related buyer with id : " + id + " not found"));
        return Optional.of(buyer);
    }

    public BuyerDTO getBuyerDTOById(Long id) {
        Optional<Buyer> buyerOptional = findBuyerById(id);
        return BuyerMapper.toDto(buyerOptional.get());
    }

    public List<BuyerDTO> getAllOrders() {
        return buyerRepository.findAll()
                .stream()
                .map(BuyerMapper::toDto)
                .collect(Collectors.toList());
    }

    public void createBuyer(BuyerDTO buyerDTO) {
        buyerRepository.save(BuyerMapper.toEntity(buyerDTO));
    }

    public void updateBuyer(Long id, BuyerDTO buyerDTO) {
//        BuyerDTO buyerDTO1 = getAllOrders().stream()
//                .filter(b -> b.getBuyerId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new BuyerNotFoundException("Couldn't update. Buyer with id: " + id + " not found"));
//        Optional<Buyer> buyerById = findBuyerById(id);

        Optional<Buyer> buyerOptional = findBuyerById(id);
        buyerOptional.ifPresent(buyer -> {
            buyer.setBuyerId(buyerDTO.getBuyerId());
            buyer.setFirstName(buyerDTO.getFirstName());
            buyer.setLastName(buyerDTO.getLastName());
            buyer.setEmail(buyerDTO.getEmail());
            buyer.setPhoneNumber(buyerDTO.getPhoneNumber());
            buyerRepository.save(buyer);
        });
    }

    public void deleteBuyer(Long id) {
       Optional<Buyer> buyerById = findBuyerById(id);
        buyerById.ifPresent(buyerRepository::delete);
    }
}
