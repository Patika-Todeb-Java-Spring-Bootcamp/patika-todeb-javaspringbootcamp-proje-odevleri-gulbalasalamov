package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;

public class BuyerMapper {
    public static BuyerDTO toDto(Buyer buyer) {
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setBuyerId(buyer.getBuyerId());
        buyerDTO.setFirstName(buyer.getFirstName());
        buyerDTO.setLastName(buyer.getLastName());
        buyerDTO.setEmail(buyer.getEmail());
        buyerDTO.setActive(buyer.isActive());
        return buyerDTO;
    }

    public static Buyer toEntity(BuyerDTO buyerDTO) {
        Buyer buyer = new Buyer();
        buyer.setBuyerId(buyerDTO.getBuyerId());
        buyer.setFirstName(buyerDTO.getFirstName());
        buyer.setLastName(buyerDTO.getLastName());
        buyer.setEmail(buyerDTO.getEmail());
        buyer.setActive(buyerDTO.isActive());
        return buyer;
    }
}
