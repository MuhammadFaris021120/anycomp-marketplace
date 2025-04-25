package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Purchase;
import com.anycomp.marketplace.service.PurchaseService;
import com.anycomp.marketplace.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseService purchaseService, PurchaseRepository purchaseRepository) {
        this.purchaseService = purchaseService;
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public Purchase buyItem(@RequestBody PurchaseRequest request) {
        return purchaseService.buyItem(request.getBuyerId(), request.getItemId(), request.getQuantity());
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public static class PurchaseRequest {
        private Long buyerId;
        private Long itemId;
        private int quantity;

        public Long getBuyerId() { return buyerId; }
        public void setBuyerId(Long buyerId) { this.buyerId = buyerId; }

        public Long getItemId() { return itemId; }
        public void setItemId(Long itemId) { this.itemId = itemId; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}

