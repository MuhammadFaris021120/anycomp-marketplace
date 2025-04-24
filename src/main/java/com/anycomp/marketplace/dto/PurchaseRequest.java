package com.anycomp.marketplace.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request body for making a purchase")
public class PurchaseRequest {

    @Schema(description = "ID of the buyer", example = "1")
    private Long buyerId;

    @Schema(description = "ID of the item", example = "10")
    private Long itemId;

    @Schema(description = "Quantity to buy", example = "2")
    private int quantity;

    public Long getBuyerId() { return buyerId; }
    public void setBuyerId(Long buyerId) { this.buyerId = buyerId; }

    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
