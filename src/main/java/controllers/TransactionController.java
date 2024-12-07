package controllers;

import services.TransactionService;
import models.Claim;
import models.Item;
import java.util.List;

public class TransactionController {
    private TransactionService transactionService = new TransactionService();

    // Claim an item
    public boolean claimItem(Claim claim) {
        return transactionService.claimItem(claim);
    }

    // Update claim status
    public boolean updateClaimStatus(int claimId, String status) {
        return transactionService.updateClaimStatus(claimId, status);
    }

    // Get claims by charity
    public List<Claim> getClaimsByCharity(int charityId) {
        return transactionService.getClaimsByCharity(charityId);
    }

    // Purchase an item
    public boolean purchaseItem(int userId, int itemId, int quantity) {
        return transactionService.purchaseItem(userId, itemId, quantity);
    }

    // Get purchases by user
    public List<Item> getPurchasesByUser(int userId) {
        return transactionService.getPurchasesByUser(userId);
    }
}
