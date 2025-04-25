package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.repository.BuyerRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Page<Buyer> getAllBuyers(Pageable pageable) {
        return buyerRepository.findAll(pageable);
    }

    public Optional<Buyer> getBuyerById(Long id) {
        return buyerRepository.findById(id);
    }

    public Buyer createBuyer(Buyer buyer) {
        if (buyerRepository.existsByEmail(buyer.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return buyerRepository.save(buyer);
    }

    public Buyer updateBuyer(Long id, Buyer updatedBuyer) {
        return buyerRepository.findById(id)
                .map(buyer -> {
                    buyer.setName(updatedBuyer.getName());
                    buyer.setEmail(updatedBuyer.getEmail());
                    return buyerRepository.save(buyer);
                }).orElseThrow();
    }

    public void deleteBuyer(Long id) {
        buyerRepository.deleteById(id);
    }
}
