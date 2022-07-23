package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;

public class BuyerMapper {
    public BuyerDTO toDto(Buyer buyer) {
        BuyerDTO buyerDTO = new BuyerDTO();
        buyerDTO.setFirstName(buyer.getFirstName());
        buyerDTO.setLastName(buyer.getLastName());
        buyerDTO.setOrders(buyer.getOrders());
        return buyerDTO;

//        return new BuyerDTO(
//                buyer.getFirstName(),buyer.getLastName(),buyer.getOrders()
//        );
    }

    public Buyer toEntity(BuyerDTO buyerDTO) {
        Buyer buyer = new Buyer();
        buyer.setFirstName(buyerDTO.getFirstName());
        buyer.setLastName(buyerDTO.getLastName());
        buyer.setOrders(buyerDTO.getOrders());
        return buyer;
    }
}
