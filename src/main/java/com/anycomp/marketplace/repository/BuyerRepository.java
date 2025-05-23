package com.anycomp.marketplace.repository;

import com.anycomp.marketplace.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;  // Add this import

public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    boolean existsByEmail(String email);
    Optional<Buyer> findByEmail(String email);

}
