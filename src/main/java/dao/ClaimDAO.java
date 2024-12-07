package dao;
import java.util.ArrayList;
import java.util.List;

import models.Claim;
import utils.DatabaseConnection;
import java.sql.*;

public class ClaimDAO {

    // Add a new claim for an item by a charity
    public boolean addClaim(Claim claim) {
        String query = "INSERT INTO claims (itemId, charityId, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, claim.getItemId());
            stmt.setInt(2, claim.getCharityId());
            stmt.setString(3, claim.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update the status of a claim
    public boolean updateClaimStatus(int claimId, String status) {
        String query = "UPDATE claims SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, claimId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all claims by a specific charity
    public List<Claim> getClaimsByCharity(int charityId) {
        List<Claim> claims = new ArrayList<>();
        String query = "SELECT * FROM claims WHERE charityId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, charityId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Claim claim = new Claim(
                        rs.getInt("id"),
                        rs.getInt("itemId"),
                        rs.getInt("charityId"),
                        rs.getString("status")
                );
                claims.add(claim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return claims;
    }
}
