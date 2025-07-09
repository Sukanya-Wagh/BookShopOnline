package model;

public class Book {
    private int bookId;
    private String title;
    private int authorId;
    private int categoryId;
    private double price;
    private int stock;
    private String description;

    
    public Book(String title, int authorId, int categoryId, double price, int stock) {
        this.title = title;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.price = price;
        this.stock = stock;
        this.description = "Basic Book Description"; 
    }

    
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
