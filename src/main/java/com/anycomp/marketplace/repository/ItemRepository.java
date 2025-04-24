package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsByNameAndSellerId(String name, Long sellerId);

    List<Item> findBySellerId(Long sellerId);
}
