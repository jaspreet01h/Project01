package main;

import dao.InventoryDAO;
import dao.UserDAO;
import dao.SubscriptionsDAO;

import java.sql.Date;
import java.util.*;

public class mainApp {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        InventoryDAO inventoryDAO = new InventoryDAO();
        SubscriptionsDAO subscriptionsDAO = new SubscriptionsDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Food Waste Reduction Platform!");
        boolean running = true;

        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Register a user");
            System.out.println("2. Login");
            System.out.println("3. Add inventory (Retailer)");
            System.out.println("4. List surplus food items");
            System.out.println("5. Claim surplus food (Charity)");
            System.out.println("6. Purchase surplus food (Consumer)");
            System.out.println("7. Subscribe to surplus food alerts");
            System.out.println("8. View statistics (Admin/Bonus)");
            System.out.println("9. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    // Register a user
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter your user type (retailer/consumer/charity): ");
                    String userType = scanner.nextLine();

                    if (userDAO.registerUser(name, email, password, userType)) {
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("User registration failed.");
                    }
                    break;

                case 2:
                    // Login (For simplicity, just check email and user type)
                    System.out.print("Enter your email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter your user type (retailer/consumer/charity): ");
                    String loginUserType = scanner.nextLine();

                    if (userDAO.isEmailRegistered(loginEmail)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Please register first.");
                    }
                    break;

                case 3:
                    // Add inventory (Retailer)
                    System.out.print("Enter retailer ID: ");
                    int retailerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    String expiryDate = scanner.next();

                    if (inventoryDAO.addInventory(retailerId, itemName, quantity, Date.valueOf(expiryDate))) {
                        System.out.println("Inventory item added successfully!");
                    } else {
                        System.out.println("Failed to add inventory item.");
                    }
                    break;

                case 4:
                    // List surplus food items
                    System.out.println("Surplus Food Items:");
                    inventoryDAO.listSurplusItems().forEach(item -> {
                        System.out.println("ID: " + item.getClass() + ", Name: " + item.getClass() +
                                ", Quantity: " + item.getClass() + ", Expiry Date: " + item.getClass());
                    });
                    break;

                case 5:
                    // Claim surplus food (Charity)
                    System.out.print("Enter charity ID: ");
                    int charityId = scanner.nextInt();
                    System.out.print("Enter item ID to claim: ");
                    int itemIdToClaim = scanner.nextInt();

                    if (inventoryDAO.claimFood(itemIdToClaim, charityId)) {
                        System.out.println("Food item claimed successfully!");
                    } else {
                        System.out.println("Failed to claim food item.");
                    }
                    break;

                case 6:
                    // Purchase surplus food (Consumer)
                    System.out.print("Enter consumer ID: ");
                    int consumerId = scanner.nextInt();
                    System.out.print("Enter item ID to purchase: ");
                    int itemIdToPurchase = scanner.nextInt();

                    if (inventoryDAO.purchaseItem(itemIdToPurchase, consumerId)) {
                        System.out.println("Food item purchased successfully!");
                    } else {
                        System.out.println("Failed to purchase food item.");
                    }
                    break;

                case 7:
                    // Subscribe to surplus food alerts
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter communication method (email/phone): ");
                    String method = scanner.nextLine();
                    System.out.print("Enter food preferences: ");
                    String preferences = scanner.nextLine();

                    if (subscriptionsDAO.subscribeToAlerts(userId, location, method, preferences)) {
                        System.out.println("Subscribed to alerts successfully!");
                    } else {
                        System.out.println("Failed to subscribe to alerts.");
                    }
                    break;


                case 9:
                    // Exit the application
                    running = false;
                    System.out.println("Exiting the platform. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
