package services;

import java.util.ArrayList;
import java.util.List;

public class AlertService {

    private List<String> subscribedUsers = new ArrayList<>();

    // Subscribe user to alerts
    public void subscribeUser(String userContact) {
        subscribedUsers.add(userContact);
    }

    // Notify users of surplus items
    public void notifySurplus(String itemName) {
        for (String user : subscribedUsers) {
            System.out.println("Alert sent to " + user + ": Surplus item available - " + itemName);
        }
    }
}
