package services;

import dao.ClaimDAO;
import dao.PurchaseDAO;
import models.Claim;
import models.Item;

import java.util.List;

public class TransactionService {
    private ClaimDAO claimDAO = new ClaimDAO();
    private PurchaseDAO purchaseDAO = new PurchaseDAO();

    // Claim an item for a charity
    public boolean claimItem(Claim claim) {
        return claimDAO.addClaim(claim);
    }

    // Update claim status
    public boolean updateClaimStatus(int claimId, String status) {
        return claimDAO.updateClaimStatus(claimId, status);
    }

    // Retrieve claims by charity
    public List<Claim> getClaimsByCharity(int charityId) {
        return claimDAO.getClaimsByCharity(charityId);
    }

    // Purchase an item by a consumer
    public boolean purchaseItem(int userId, int itemId, int quantity) {
        return purchaseDAO.addPurchase(userId, itemId, quantity);
    }

    // Retrieve purchase history for a user
    public List<Item> getPurchasesByUser(int userId) {
        return purchaseDAO.getPurchasesByUser(userId);
    }
}
