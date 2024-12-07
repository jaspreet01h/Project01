package test;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDAO {

    public boolean executeTransaction(int userId, int itemId, String transactionType) {
        String insertTransactionQuery = "INSERT INTO transactions (item_id, user_id, transaction_type) VALUES (?, ?, ?)";
        String updateInventoryQuery = "UPDATE inventory SET quantity = quantity - 1 WHERE id = ? AND quantity > 0";

        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false); // Start transaction

            // Insert transaction
            try (PreparedStatement insertStmt = conn.prepareStatement(insertTransactionQuery)) {
                insertStmt.setInt(1, itemId);
                insertStmt.setInt(2, userId);
                insertStmt.setString(3, transactionType);
                insertStmt.executeUpdate();
            }

            // Update inventory
            try (PreparedStatement updateStmt = conn.prepareStatement(updateInventoryQuery)) {
                updateStmt.setInt(1, itemId);
                updateStmt.executeUpdate();
            }

            conn.commit(); // Commit transaction
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            try (Connection conn = DatabaseConnection.getConnection()) {
                conn.rollback(); // Rollback transaction on error
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return false;
        }
    }

    public <Transaction> Transaction purchaseItem(int id, int id1) {
        return null;
    }

    public <Transaction> Transaction claimItem(int id, int id1) {
        return null;
    }
}
