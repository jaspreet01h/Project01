package services;

import dao.InventoryDAO;
import models.Item;
import java.util.List;

public class InventoryService {
    private InventoryDAO inventoryDAO = new InventoryDAO();

    // Retrieve all items in the inventory
    public List<Item> getAllItems() {
        return inventoryDAO.getAllItems();
    }

    // Add a new item to the inventory
    public boolean addItem(Item item) {
        return inventoryDAO.addItem(item);
    }

    // Update an existing item in the inventory
    public boolean updateItem(Item item) {
        return inventoryDAO.updateItem(item);
    }
}
