package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.repository.ItemRepository;
import com.anycomp.marketplace.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final SellerRepository sellerRepository;

    public ItemService(ItemRepository itemRepository, SellerRepository sellerRepository) {
        this.itemRepository = itemRepository;
        this.sellerRepository = sellerRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getItemsBySeller(Long sellerId) {
        return itemRepository.findBySellerId(sellerId);
    }

    public Item addItemToSeller(Long sellerId, Item item) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow();
    
        // Check if an item with the same name already exists for this seller
        boolean exists = itemRepository.existsByNameAndSellerId(item.getName(), sellerId);
        if (exists) {
            throw new IllegalArgumentException("Item with the same name already exists for this seller.");
        }
    
        item.setSeller(seller);
        return itemRepository.save(item);
    }
    

    public Item updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(updatedItem.getName());
                    item.setDescription(updatedItem.getDescription());
                    item.setPrice(updatedItem.getPrice());
                    item.setQuantity(updatedItem.getQuantity());
                    return itemRepository.save(item);
                }).orElseThrow();
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    
}
