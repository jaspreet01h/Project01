package dao;

import utils.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class SubscriptionsDAO {

    // Subscribe a user to surplus food alerts
    public boolean subscribeToAlerts(int userId, String location, String method, String preferences) {
        String query = "INSERT INTO subscriptions (user_id, location, communication_method, food_preferences) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setString(2, location);
            stmt.setString(3, method);
            stmt.setString(4, preferences);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all subscriptions (useful for sending notifications)
    public List<Map<String, String>> getAllSubscriptions() {
        String query = "SELECT s.id, s.user_id, u.email, s.location, s.communication_method, s.food_preferences " +
                "FROM subscriptions s JOIN users u ON s.user_id = u.id";
        List<Map<String, String>> subscriptions = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Map<String, String> subscription = new HashMap<>();
                subscription.put("id", String.valueOf(rs.getInt("id")));
                subscription.put("userId", String.valueOf(rs.getInt("user_id")));
                subscription.put("email", rs.getString("email"));
                subscription.put("location", rs.getString("location"));
                subscription.put("method", rs.getString("communication_method"));
                subscription.put("preferences", rs.getString("food_preferences"));
                subscriptions.add(subscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscriptions;
    }

    // Notify users about surplus food based on their subscriptions
    public void notifyUsersAboutSurplus(List<Map<String, Object>> surplusItems) {
        List<Map<String, String>> subscriptions = getAllSubscriptions();

        for (Map<String, String> subscription : subscriptions) {
            for (Map<String, Object> item : surplusItems) {
                // Customize notifications based on user preferences or location (if applicable)
                String email = subscription.get("email");
                String itemName = (String) item.get("itemName");
                System.out.println("Sending notification to: " + email + " about surplus item: " + itemName);

                // You can integrate an email/notification service here to send actual alerts
            }
        }
    }
}
