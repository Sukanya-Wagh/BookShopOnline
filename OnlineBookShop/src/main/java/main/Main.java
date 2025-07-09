package main;

import dao.DBConnection;
import dao.UserDAO;
import model.User;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            // Establish DB connection
            Connection con = DBConnection.getConnection();
            System.out.println("Connected to DB!");

            // Initialize DAO class
            UserDAO userDAO = new UserDAO(con);

            // Insert a new user (including password)
            User user1 = new User("john_doe", "john@example.com", "password123", "1234567890", "123 Street, City", "customer");
            userDAO.insertUser(user1);
            System.out.println("User inserted!");

            // Fetch and print all users
            System.out.println("Users in DB:");
            for (User u : userDAO.getAllUsers()) {
                System.out.println(u);
            }

            // Update user details
            user1.setUsername("john_doe_updated");
            user1.setPassword("newpassword123");
            userDAO.updateUser(user1);
            System.out.println("User updated!");

            // Fetch and print all users after update
            System.out.println("Users in DB after update:");
            for (User u : userDAO.getAllUsers()) {
                System.out.println(u);
            }

            // Delete user
            userDAO.deleteUser(user1.getUserId());
            System.out.println("User deleted!");

            // Fetch and print all users after deletion
            System.out.println("Users in DB after deletion:");
            for (User u : userDAO.getAllUsers()) {
                System.out.println(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
