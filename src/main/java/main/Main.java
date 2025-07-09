package main;

import dao.DBConnection;
import dao.UserDAO;
import dao.BookDAO;
import model.User;
import model.Book;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to Online BookShop Console Application!");
            Connection con = DBConnection.getConnection();
            System.out.println("Connected to DB successfully!\n");

            
            UserDAO userDAO = new UserDAO(con);
            User user = new User("gauri_wagh", "gauri@example.com", "gauri123", "9876500011", "Mumbai", "customer");
            userDAO.insertUser(user);
            System.out.println("User inserted: " + user.getUsername());

            
            System.out.println("\nUsers in the database:");
            List<User> users = userDAO.getAllUsers();
            for (User u : users) {
                System.out.println(u.getUserId() + " | " + u.getUsername() + " | " + u.getEmail());
            }


            BookDAO bookDAO = new BookDAO(con);

            
            System.out.println("\nBooks in the database:");
            List<Book> books = bookDAO.getAllBooks();
            for (Book b : books) {
                System.out.println(b.getBookId() + " | " + b.getTitle() + " | ₹" + b.getPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
