package dao;

import model.Author;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {

    // ➕ Add Author
    public boolean addAuthor(Author author) {
        String sql = "INSERT INTO author (name) VALUES (?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, author.getName());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 📋 Get All Authors
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        String sql = "SELECT * FROM author";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Author a = new Author(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                authors.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return authors;
    }

    // ✏️ Update Author
    public boolean updateAuthor(Author author) {
        String sql = "UPDATE author SET name = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, author.getName());
            ps.setInt(2, author.getAuthorId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ❌ Delete Author
    public boolean deleteAuthor(int id) {
        String sql = "DELETE FROM author WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
