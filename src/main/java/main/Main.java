package main;

import dao.BookDAO;
import dao.UserDAO;
import model.Book;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAO userDao = new UserDAO();
        BookDAO bookDao = new BookDAO();

        System.out.println("Welcome to Online BookShop Console Application!");
        System.out.println("Connected to DB successfully!");

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Insert New User");
            System.out.println("2. View All Users");
            System.out.println("3. Insert New Book");
            System.out.println("4. View All Books");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    User user = new User();
                    System.out.print("Enter username: ");
                    user.setUsername(sc.nextLine());

                    System.out.print("Enter email: ");
                    user.setEmail(sc.nextLine());

                    System.out.print("Enter password: ");
                    user.setPassword(sc.nextLine());

                    System.out.print("Enter mobile number: ");
                    user.setMobile(sc.nextLine());

                    System.out.print("Enter city: ");
                    user.setCity(sc.nextLine());

                    System.out.print("Enter role (customer/admin): ");
                    user.setRole(sc.nextLine());

                    userDao.insertUser(user);
                    break;

                case 2:
                    userDao.viewAllUsers();
                    break;

                case 3:
                    Book book = new Book();
                    System.out.print("Enter book title: ");
                    book.setTitle(sc.nextLine());

                    System.out.print("Enter authorId: ");
                    book.setAuthorId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter categoryId: ");
                    book.setCategoryId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter price: ");
                    book.setPrice(Double.parseDouble(sc.nextLine()));

                    System.out.print("Enter stock: ");
                    book.setStock(Integer.parseInt(sc.nextLine()));

                    bookDao.insertBook(book);
                    break;

                case 4:
                    bookDao.viewAllBooks();
                    break;

                case 0:
                    System.out.println("Thank you for using BookShop!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
