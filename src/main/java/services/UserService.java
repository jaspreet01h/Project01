package services;

import dao.UserDAO;
import models.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    // Register a new user
    public boolean registerUser(User user) {
        return userDAO.registerUser(user);
    }

    // Authenticate a user login
    public User loginUser(String email, String password) {
        return userDAO.loginUser(email, password);
    }

    // Retrieve user by ID
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }
}
