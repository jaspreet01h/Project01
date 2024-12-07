package dao;

import models.Item;
import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {

    // Record a purchase by a consumer
    public boolean addPurchase(int userId, int itemId, int quantity) {
        String query = "INSERT INTO purchases (userId, itemId, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, itemId);
            stmt.setInt(3, quantity);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all purchases made by a specific user
    public List<Item> getPurchasesByUser(int userId) {
        List<Item> purchasedItems = new ArrayList<>();
        String query = "SELECT i.* FROM purchases p JOIN inventory i ON p.itemId = i.id WHERE p.userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDate("expirationDate"),
                        rs.getBoolean("isSurplus")
                );
                purchasedItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return purchasedItems;
    }
}
