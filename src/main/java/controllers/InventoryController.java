package controllers;

import services.InventoryService;
import models.Item;
import java.util.List;

public class InventoryController {
    private InventoryService inventoryService = new InventoryService();

    // Retrieve all items
    public List<Item> getAllItems() {
        return inventoryService.getAllItems();
    }

    // Add a new item to the inventory
    public boolean addItem(Item item) {
        return inventoryService.addItem(item);
    }

    // Update an item in the inventory
    public boolean updateItem(Item item) {
        return inventoryService.updateItem(item);
    }
}
