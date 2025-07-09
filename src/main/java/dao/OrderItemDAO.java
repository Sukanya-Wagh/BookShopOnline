package dao;

import model.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO {
    private Connection con;

    public OrderItemDAO(Connection con) {
        this.con = con;
    }

    public void insertOrderItem(OrderItem orderItem) throws SQLException {
        String sql = "INSERT INTO order_items (order_id, book_id, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pst.setInt(1, orderItem.getOrderId());
            pst.setInt(2, orderItem.getBookId());
            pst.setInt(3, orderItem.getQuantity());
            pst.setBigDecimal(4, orderItem.getPrice());
            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    orderItem.setOrderItemId(rs.getInt(1));
                }
            }
        }
    }

    public OrderItem getOrderItemById(int orderItemId) throws SQLException {
        OrderItem orderItem = null;
        String sql = "SELECT * FROM order_items WHERE order_item_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, orderItemId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    orderItem = extractOrderItemFromResultSet(rs);
                }
            }
        }
        return orderItem;
    }

    public List<OrderItem> getAllOrderItems() throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        String sql = "SELECT * FROM order_items";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                items.add(extractOrderItemFromResultSet(rs));
            }
        }
        return items;
    }

   
    public void updateOrderItem(OrderItem orderItem) throws SQLException {
        String sql = "UPDATE order_items SET order_id=?, book_id=?, quantity=?, price=? WHERE order_item_id=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, orderItem.getOrderId());
            pst.setInt(2, orderItem.getBookId());
            pst.setInt(3, orderItem.getQuantity());
            pst.setBigDecimal(4, orderItem.getPrice());
            pst.setInt(5, orderItem.getOrderItemId());
            pst.executeUpdate();
        }
    }

    public void deleteOrderItem(int orderItemId) throws SQLException {
        String sql = "DELETE FROM order_items WHERE order_item_id=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, orderItemId);
            pst.executeUpdate();
        }
    }

    private OrderItem extractOrderItemFromResultSet(ResultSet rs) throws SQLException {
        OrderItem item = new OrderItem();
        item.setOrderItemId(rs.getInt("order_item_id"));
        item.setOrderId(rs.getInt("order_id"));
        item.setBookId(rs.getInt("book_id"));
        item.setQuantity(rs.getInt("quantity"));
        item.setPrice(rs.getBigDecimal("price"));
        return item;
    }
}
