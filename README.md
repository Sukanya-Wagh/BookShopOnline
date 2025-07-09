#  Online BookShop – Java Console Project

A Java-based console application that simulates an online bookshop. Users can register, log in, browse books, place orders, and view purchase history. This project is built using **Core Java**, **JDBC**, **PostgreSQL**, and **Maven**.

---

##  Features

-  **User Registration & Login System**
-  **View Available Books** – by category, author, title
-  **Add Books to Cart**
-  **Place Orders**
-  **Order History Viewing**
-  **Sales Report Generation**
-  **Delete or Update Book Information (Admin)**
- Menu-Driven Console Interface

---

##  Technologies Used

- **Core Java** – OOP concepts, collections
- **JDBC (Java Database Connectivity)** – for database communication
- **PostgreSQL** – relational database
- **Maven** – project build & dependency management
- **Eclipse IDE**

---

##  Dependencies

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>

##Database Tables.

CREATE TABLE user_details (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(150),
    role VARCHAR(50) DEFAULT 'user'
);

CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author_id INT REFERENCES authors(author_id),
    category_id INT REFERENCES categories(category_id),
    price NUMERIC(10, 2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    user_id INT REFERENCES user_details(user_id),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount NUMERIC(10, 2) NOT NULL
);

CREATE TABLE order_items (
    item_id SERIAL PRIMARY KEY,
    order_id INT REFERENCES orders(order_id),
    book_id INT REFERENCES books(book_id),
    quantity INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

## Prerequisites
1)Java JDK 

2)Apache Maven 

3)PostgreSQL 

4)Eclipse IDE / IntelliJ

📁 Directory Structure

OnlineBookshop/

├── Main.java

├── DBConnection.java

├── dao/

│   ├── UserDAO.java

│   ├── AuthorDAO.java

│   ├── CategoryDAO.java

│   ├── BookDAO.java

│   ├── OrderDAO.java

│   ├── OrderItemDAO.java

├── model/

│   ├── User.java

│   ├── Author.java

│   ├── Category.java

│   ├── Book.java

│   ├── Order.java

│   ├── OrderItem.java
 
2) 

✅ all DAO implementations (UserDAO, OrderDAO, etc.)?
 
✅ Generate model classes
 
✅ Add full ordering flow (order, order items)?
 
✅ Add update/delete/search menus
 
Add update/delete functionality for books/users
 
Add search/filter by category or author
 
Create reporting (sales per author/category)
 
Search books by title, author, category
 
List orders by user
 
Filter books by category or author
 
🔍 Search books by title
 
🧑‍💻 Filter books by author
 
📚 Filter books by category
 
📦 View orders by user

📊 Sales Reporting:
 
Total sales per category
 
Best-selling books
 
Revenue summary


👩‍💻 Developer
Name: Sukanya Wagh
Email: waghsukanya153@gmail.com
GitHub: Sukanya-Wagh

**Enjoy using the Online BookShop Project! 🚀**
