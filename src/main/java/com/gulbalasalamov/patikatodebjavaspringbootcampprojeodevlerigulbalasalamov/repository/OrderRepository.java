package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
