package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.repository.SellerRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }

    public Seller createSeller(Seller seller) {
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
