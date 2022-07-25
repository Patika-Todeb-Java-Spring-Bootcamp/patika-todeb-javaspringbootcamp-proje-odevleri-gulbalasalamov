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

    protected Optional<Buyer> findBuyerDTOById(Long id) {
        return buyerRepository.findById(id);
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
//        BuyerDTO buyerDTO1 = getAllOrders().stream()
//                .filter(b -> b.getBuyerId().equals(id))
//                .findFirst()
//                .orElseThrow(() -> new BuyerNotFoundException("Couldn't update. Buyer with id: " + id + " not found"));

        if (getBuyerById(id).getBuyerId() == null) {
            throw new BuyerNotFoundException("Buyer with " + id + "not found. Couldn't delete");
        }
        buyerRepository.save(BuyerMapper.toEntity(buyerDTO));
    }

    public void deleteBuyer(Long id) {
        Buyer buyer = buyerRepository.findById(id).orElseThrow(() -> new BuyerNotFoundException("Related buyer with id : " + id + "not found"));
        buyerRepository.delete(buyer);
    }
}
