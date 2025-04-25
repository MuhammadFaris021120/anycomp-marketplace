package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    boolean existsByEmail(String email);
    Page<Seller> findAll(Pageable pageable);

}
