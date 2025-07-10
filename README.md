# 📚 Online BookShop – Java Console Project

A Java-based console application that simulates an online bookshop. Users can register, log in, browse books, place orders, and view purchase history. This project is built using **Core Java**, **JDBC**, **PostgreSQL**, and **Maven**.

---

## ✨ Features

- 🧾 User Registration & Login System 
- 📖 View Available Books – by category, author, or title  
- 🛒 Add Books to Cart  
- 📦 Place Orders  
- 📜 View Order History  
- 📊 Sales Report Generation  
- 🛠️ Admin Options – Delete or Update Book Information  
- 📋 Menu-Driven Console Interface  

---

## 💻 Technologies Used

- ☕ Core Java – OOP concepts, Collections  
- 🔌 JDBC – Java Database Connectivity  
- 🗄️ PostgreSQL – Relational Database  
- 📦 Maven – Build & Dependency Management  
- 🧠 Eclipse IDE  

---

## 📦 Dependencies

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>

🗃️ Database Tables

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

⚙️ Prerequisites
1)Java JDK

2) Apache Maven

3)PostgreSQL

4) Eclipse IDE / IntelliJ

OnlineBookshop/
├── Main.java
├── DBConnection.java
├── dao/
│   ├── UserDAO.java
│   ├── AuthorDAO.java
│   ├── CategoryDAO.java
│   ├── BookDAO.java
│   ├── OrderDAO.java
│   └── OrderItemDAO.java
├── model/
│   ├── User.java
│   ├── Author.java
│   ├── Category.java
│   ├── Book.java
│   ├── Order.java
│   └── OrderItem.java
🔧 Project Functionalities
✅ User & Admin Actions
Register, Login

View books (by title, author, category)

Add to cart & Place order

View personal order history

Admin can add/update/delete books

Admin can manage users

📦 Order System
Full order flow – including order_items handling

Calculate total price, update stock

🔍 Search & Filter
Search books by:

🔤 Title

👤 Author

🗂️ Category

Filter books accordingly

📊 Sales Reporting
📈 Total sales per category

🏆 Best-selling books

💰 Revenue summary

👩‍💻 Developer Info

Name: Sukanya Wagh
Email: waghsukanya153@gmail.com
GitHub: Sukanya-Wagh

🚀 Enjoy using the Online BookShop Project!


## 📸 Final Output Screenshot

![Output](https://private-user-images.githubusercontent.com/217532567/464330296-72258ecf-e6ce-4e2d-9926-3175dda3cf6a.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NTIxMTM3NjIsIm5iZiI6MTc1MjExMzQ2MiwicGF0aCI6Ii8yMTc1MzI1NjcvNDY0MzMwMjk2LTcyMjU4ZWNmLWU2Y2UtNGUyZC05OTI2LTMxNzVkZGEzY2Y2YS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNzEwJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDcxMFQwMjExMDJaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03Y2FjNTQ4MTA0M2QyNTJmN2U1ODNmZDdmZWUxZTViZGViYTIzNTFlOGI2MDg5ZjRiNWI1NmI3OTRhOGZmYzgwJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.6A0ffTeMiVgn2PajOFYeYijSiexKAkCEDXRy1bpf-5E)
