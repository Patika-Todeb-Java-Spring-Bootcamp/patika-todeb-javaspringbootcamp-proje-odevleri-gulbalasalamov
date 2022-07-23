package com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.repository;

import com.gulbalasalamov.patikatodebjavaspringbootcampprojeodevlerigulbalasalamov.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
