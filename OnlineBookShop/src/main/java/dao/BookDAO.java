package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }

    // Insert Book
    public void insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO book (title, author_id, category_id, price, quantity, description) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, book.getTitle());
            pst.setInt(2, book.getAuthorId());
            pst.setInt(3, book.getCategoryId());
            pst.setBigDecimal(4, book.getPrice());
            pst.setInt(5, book.getQuantity());
            pst.setString(6, book.getDescription());
            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    book.setBookId(rs.getInt(1));
                }
            }
        }
    }

    // Get Book by ID
    public Book getBookById(int bookId) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, bookId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    book = extractBookFromResultSet(rs);
                }
            }
        }
        return book;
    }

    // Get all Books
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY title";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                books.add(extractBookFromResultSet(rs));
            }
        }
        return books;
    }

    // Search books by title (partial match)
    public List<Book> searchBooksByTitle(String title) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE title ILIKE ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, "%" + title + "%");
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    books.add(extractBookFromResultSet(rs));
                }
            }
        }
        return books;
    }

    // Filter books by author_id
    public List<Book> filterBooksByAuthor(int authorId) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE author_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, authorId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    books.add(extractBookFromResultSet(rs));
                }
            }
        }
        return books;
    }

    // Filter books by category_id
    public List<Book> filterBooksByCategory(int categoryId) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book WHERE category_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, categoryId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    books.add(extractBookFromResultSet(rs));
                }
            }
        }
        return books;
    }

    // Update Book
    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE book SET title=?, author_id=?, category_id=?, price=?, quantity=?, description=? WHERE book_id=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, book.getTitle());
            pst.setInt(2, book.getAuthorId());
            pst.setInt(3, book.getCategoryId());
            pst.setBigDecimal(4, book.getPrice());
            pst.setInt(5, book.getQuantity());
            pst.setString(6, book.getDescription());
            pst.setInt(7, book.getBookId());
            pst.executeUpdate();
        }
    }

    // Delete Book
    public void deleteBook(int bookId) throws SQLException {
        String sql = "DELETE FROM book WHERE book_id=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, bookId);
            pst.executeUpdate();
        }
    }

    // Helper method to extract Book from ResultSet
    private Book extractBookFromResultSet(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setBookId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setCategoryId(rs.getInt("category_id"));
        book.setPrice(rs.getBigDecimal("price"));
        book.setQuantity(rs.getInt("quantity"));
        book.setDescription(rs.getString("description"));
        return book;
    }
}
