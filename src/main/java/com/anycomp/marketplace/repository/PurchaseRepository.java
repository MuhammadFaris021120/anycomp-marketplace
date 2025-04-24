package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
