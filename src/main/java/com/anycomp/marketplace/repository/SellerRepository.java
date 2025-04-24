package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
