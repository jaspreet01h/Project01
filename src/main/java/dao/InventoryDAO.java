package dao;

import models.Item;
import utils.DatabaseConnection;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class InventoryDAO {

    // Add inventory item
    public boolean addInventory(int retailerId, String itemName, int quantity, Date expiryDate) {
        String query = "INSERT INTO inventory (retailer_id, item_name, quantity, expiry_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, retailerId);
            stmt.setString(2, itemName);
            stmt.setInt(3, quantity);
            stmt.setDate(4, new Date(expiryDate.getTime()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update inventory item
    public boolean updateInventory(int itemId, int newQuantity) {
        String query = "UPDATE inventory SET quantity = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, newQuantity);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Flag surplus food
    public boolean flagSurplusFood() {
        String query = "UPDATE inventory SET surplus_flag = TRUE WHERE expiry_date <= CURDATE() + INTERVAL 7 DAY";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addItem(Item item) {
        return false;
    }

    public List<Item> getAllItems() {
        return List.of();
    }

    public boolean updateItem(Item item) {
        return false;
    }

    public boolean claimFood(int itemIdToClaim, int charityId) {
        return false;
    }

    public Iterable<Object> listSurplusItems() {
        return null;
    }

    public boolean purchaseItem(int itemIdToPurchase, int consumerId) {
        return false;
    }

    public Iterable<Object> getFoodStats() {
        return null;
    }
}
