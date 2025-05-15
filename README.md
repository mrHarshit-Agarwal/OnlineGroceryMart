# 🛒 Online Grocery Store - Spring MVC Web Application

A web-based **Online Grocery Store** built using **Spring MVC**, allowing users to **add**, **view**, **search**, and **purchase grocery items**. The application follows a layered architecture with proper validations, views, and database integration.

---

## ✅ Features

### 1. Add Grocery Items
- Fields: 
  - `productId` (Auto-generated)
  - `name` (String)
  - `category` (String)
  - `price` (Double)
  - `stockQuantity` (Integer)
- Validations applied via Spring Validator or JSR-303 annotations.

### 2. Display All Products
- Displays all products in a **tabular format** using JSP/Thymeleaf frontend.
- Data fetched from the database via Spring MVC controllers and displayed using a view template.

### 3. Search Products by Name or Category
- Input is validated.
- If the product exists, its details are displayed.
- If not, a message like "**Product not available**" is shown.

### 4. Purchase Products
- Validates if the product is available and in stock.
- If available:
  - Displays **bill**
  - Reduces the stock quantity accordingly
- If not:
  - Displays “**Product not available**”

---

## 💻 Tech Stack

- **Spring MVC**
- **Hibernate / JPA**
- **MySQL**
- **JSP**
- **Tomcat Server**

---

