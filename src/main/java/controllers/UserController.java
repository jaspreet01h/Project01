package controllers;

import services.UserService;
import models.User;

public class UserController {
    private UserService userService = new UserService();

    // Register a new user
    public boolean registerUser(User user) {
        return userService.registerUser(user);
    }

    // Login user
    public User loginUser(String email, String password) {
        return userService.loginUser(email, password);
    }

    // Retrieve user by ID
    public User getUserById(int id) {
        return userService.getUserById(id);
    }
}
