package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.service.BuyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable Long id) {
        return buyerService.getBuyerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Buyer createBuyer(@RequestBody Buyer buyer) {
        return buyerService.createBuyer(buyer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable Long id, @RequestBody Buyer buyer) {
        try {
            return ResponseEntity.ok(buyerService.updateBuyer(id, buyer));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyer(@PathVariable Long id) {
        buyerService.deleteBuyer(id);
        return ResponseEntity.noContent().build();
    }
}
