package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.repository.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Page<Seller> getAllSellers(Pageable pageable) {
        return sellerRepository.findAll(pageable);
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public Seller createSeller(Seller seller) {
        boolean exists = sellerRepository.existsByEmail(seller.getEmail());
        if (exists) {
            throw new IllegalArgumentException("A seller with this email already exists.");
        }
        return sellerRepository.save(seller);
    }
    

    public Seller updateSeller(Long id, Seller updatedSeller) {
        return sellerRepository.findById(id)
                .map(seller -> {
                    seller.setName(updatedSeller.getName());
                    seller.setEmail(updatedSeller.getEmail());
                    return sellerRepository.save(seller);
                }).orElseThrow();
    }

    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
