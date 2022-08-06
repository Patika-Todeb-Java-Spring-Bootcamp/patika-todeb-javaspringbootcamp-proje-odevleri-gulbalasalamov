package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.service;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.dto.BuyerDTO;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Buyer;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.mapper.Mapper;
import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository.BuyerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BuyerServiceTest {

    @Mock
    private BuyerRepository buyerRepository;

    @Mock
    private Mapper mapper;

    @InjectMocks
    private BuyerService buyerService;

    @Test
    void findBuyerById() {
    }

    @Test
    void getBuyerById() {
    }

    @Test
    void getAllBuyers() {
        List<Buyer> expBuyerList = new ArrayList<>();
        Buyer buyer1 = new Buyer(1L, "Gu", "Sa", "gmal", "123", "000", "adress", false, null);
        Buyer buyer2 = new Buyer(2L, "fu", "ga", "gml", "123", "000", "adress", false, null);
        Buyer buyer3 = new Buyer(3L, "fu", "ga", "gml", "123", "000", "adress", false, null);

        expBuyerList.add(buyer2);
        expBuyerList.add(buyer1);
        expBuyerList.add(buyer3);

        // stub - after step
        Mockito.when(buyerRepository.findAll()).thenReturn(expBuyerList);

        //then - valite step
        List<Buyer> actualBuyersList = buyerRepository.findAll();

        Assert.assertEquals(expBuyerList.size(), actualBuyersList.size());

        //idlere gore siraladik
        System.out.println("First: " + expBuyerList);
        expBuyerList = expBuyerList.stream().sorted(getBuyerComparator()).collect(Collectors.toList());

        actualBuyersList = actualBuyersList.stream().sorted(getBuyerComparator()).collect(Collectors.toList());
        for (int i = 0; i < expBuyerList.size(); i++) {
            Buyer currBuyerExpected = expBuyerList.get(i);
            Buyer currBuyerActual = actualBuyersList.get(i);
            Assert.assertEquals(currBuyerExpected.getId(),currBuyerActual.getId());
            Assert.assertEquals(currBuyerExpected.getFirstName(),currBuyerActual.getFirstName());

        }
        System.out.println("Second: " + expBuyerList);



        BuyerDTO buyerDTO1 = new BuyerDTO(1L, "du", "za", "gmdssdal", "123", "000", "adress", null);
        BuyerDTO buyerDTO2 = new BuyerDTO(2L, "du", "za", "gmdssdal", "123", "000", "adress", null);
        BuyerDTO buyerDTO3 = new BuyerDTO(3L, "du", "za", "gmdssdal", "123", "000", "adress", null);

        List<BuyerDTO> expList = Arrays.asList(buyerDTO1,buyerDTO2,buyerDTO3);

        // stub - after step
        Mockito.when(buyerService.getAllBuyers()).thenReturn(expList);
        //then - valite step
        List<BuyerDTO> actList = buyerService.getAllBuyers();

        Assert.assertEquals(expList.size(), actList.size());





    }

    private Comparator<Buyer> getBuyerComparator() {
        return (o1, o2) -> {
            if (o1.getId() - o2.getId() < 0)
                return -1;
            if (o1.getId() - o2.getId() == 0)
                return 0;
            return 1;
        };
    }

    @Test
    void addBuyer() {
    }

    @Test
    void updateBuyer() {
    }

    @Test
    void deleteBuyer() {
    }

    @Test
    void addOrderToBuyer() {
    }
}