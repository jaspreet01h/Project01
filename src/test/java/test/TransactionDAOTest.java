package test;

import dao.InventoryDAO;
import models.SurplusItem;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionDAOTest<Transaction> {

    private TransactionDAO transactionDAO;
    private InventoryDAO inventoryDAO;

    @BeforeEach
    public void setUp() {
        transactionDAO = new TransactionDAO();
        inventoryDAO = new InventoryDAO();
    }

    @Test
    public void testPurchaseItem() {
        SurplusItem item = new SurplusItem("Potato", 100, Date.valueOf("2024-11-23"), 0.50);
        inventoryDAO.addItem(item);

        User consumer = new User("Charlie", "charlie@example.com", "password", "consumer");

        Transaction transaction = transactionDAO.purchaseItem(item.getId(), consumer.getId());
        assertNotNull(transaction, "Transaction should be created.");
        assertEquals(item.getId(), transaction.getClass(), "The purchased item's ID should match.");
    }

    @Test
    public void testClaimItem() {
        SurplusItem item = new SurplusItem("Lettuce", 60, Date.valueOf("2024-11-20"), 0.40);
        inventoryDAO.addItem(item);

        User charity = new User("FoodBank", "foodbank@example.com", "password", "charity");

        Transaction transaction = transactionDAO.claimItem(item.getId(), charity.getId());
        assertNotNull(transaction, "Transaction should be created for claimed item.");
        assertEquals(item.getId(), transaction.getClass(), "The claimed item's ID should match.");
    }

    private void assertNotNull(Transaction transaction, String s) {

    }
}
