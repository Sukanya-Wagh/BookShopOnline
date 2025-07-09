package model;

import java.math.BigDecimal;

public class Book {
    private int bookId;
    private String title;
    private int authorId;
    private int categoryId;
    private BigDecimal price;
    private int quantity;
    private String description;

    public Book() {}

  

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getAuthorId() { return authorId; }
    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Book{" +
            "bookId=" + bookId +
            ", title='" + title + '\'' +
            ", authorId=" + authorId +
            ", categoryId=" + categoryId +
            ", price=" + price +
            ", quantity=" + quantity +
            ", description='" + description + '\'' +
            '}';
    }
}
