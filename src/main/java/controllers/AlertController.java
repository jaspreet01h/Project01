package controllers;

import services.AlertService;

public class AlertController {
    private AlertService alertService = new AlertService();

    // Subscribe a user to alerts
    public void subscribeUser(String userContact) {
        alertService.subscribeUser(userContact);
    }

    // Notify users about a surplus item
    public void notifySurplus(String itemName) {
        alertService.notifySurplus(itemName);
    }
}
