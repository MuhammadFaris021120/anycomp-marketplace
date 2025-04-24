package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Purchase;
import com.anycomp.marketplace.service.PurchaseService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public Purchase buyItem(@RequestBody PurchaseRequest request) {
        return purchaseService.buyItem(request.getBuyerId(), request.getItemId(), request.getQuantity());
    }

    public static class PurchaseRequest {
        private Long buyerId;
        private Long itemId;
        private int quantity;

        // Getters and setters
        public Long getBuyerId() { return buyerId; }
        public void setBuyerId(Long buyerId) { this.buyerId = buyerId; }

        public Long getItemId() { return itemId; }
        public void setItemId(Long itemId) { this.itemId = itemId; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }
}
