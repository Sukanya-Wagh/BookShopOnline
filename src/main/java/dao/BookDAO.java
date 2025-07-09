package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }

  
    public void insertBook(Book book) {
        String sql = "INSERT INTO books (title, author_id, category_id, price, stock, description) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getAuthorId());
            ps.setInt(3, book.getCategoryId());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, book.getStock());
            ps.setString(6, book.getDescription());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    book.setBookId(rs.getInt(1)); // set generated ID
                }
                System.out.println("Book inserted successfully.");
            } else {
                System.out.println(" Book insertion failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, author_id, category_id, price, stock, description FROM books";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book book = new Book(
                    rs.getString("title"),
                    rs.getInt("author_id"),
                    rs.getInt("category_id"),
                    rs.getDouble("price"),
                    rs.getInt("stock")
                );
                book.setBookId(rs.getInt("book_id"));
                books.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
