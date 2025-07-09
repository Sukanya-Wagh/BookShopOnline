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
            System.out.println(" Welcome to Online BookShop Console Application!");
            Connection con = DBConnection.getConnection();
            System.out.println(" Connected to DB successfully!\n");

            UserDAO userDAO = new UserDAO(con);
            User user = new User("sukanya_wagh", "waghsukanya153@gmail.com", "pass123", "9876543210", "Pune", "customer");
            userDAO.insertUser(user);
            System.out.println(" User inserted: " + user.getUsername());

            System.out.println("\n Users in the database:");
            List<User> users = userDAO.getAllUsers();
            for (User u : users) {
                System.out.println(u.getUserId() + " | " + u.getUsername() + " | " + u.getEmail());
            }

           
            BookDAO bookDAO = new BookDAO(con);
            Book book = new Book("Java Basics", 1, 1, 499.99, 10); 
            bookDAO.insertBook(book);
            System.out.println("\n Book inserted: " + book.getTitle());

            System.out.println("\n Books in the database:");
            List<Book> books = bookDAO.getAllBooks();
            for (Book b : books) {
       
                System.out.println(b.getBookId() + " | " + b.getTitle() + " | ₹" + b.getPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
