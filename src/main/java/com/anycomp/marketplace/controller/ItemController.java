package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sellers/{sellerId}/items")
    public List<Item> getItemsBySeller(@PathVariable Long sellerId) {
        return itemService.getItemsBySeller(sellerId);
    }

    @PostMapping("/sellers/{sellerId}/items")
    public Item addItemToSeller(@PathVariable Long sellerId, @RequestBody Item item) {
        return itemService.addItemToSeller(sellerId, item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        try {
            return ResponseEntity.ok(itemService.updateItem(id, item));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
