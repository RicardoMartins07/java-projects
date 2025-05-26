# 💳 Simple Banking System

This is a console-based banking system developed in Java. It allows customers to open different types of accounts, manage their finances, and perform essential banking operations through a simple and user-friendly interface.

## 📌 Features

- ✅ **Create Customers and Accounts**  
  Users can register by providing personal information and create various account types:
    - Checking (default when creating a new user)
    - Savings
    - Business

- 💰 **Deposit and Withdraw Money**  
  Perform deposits and withdrawals while validating balance constraints.

- 🔄 **Transfer Between Accounts**  
  Supports both internal transfers (between own accounts) and external transfers (to other customers' accounts).

- 📊 **Check Balance and Transaction History**  
  Users can view account balances and detailed lists of movements (debits/credits).

- ❌ **Deactivate Account**  
  Allows customers to deactivate a specific account.

## 🛠 Technologies Used

- Java 17+
- OOP (Object-Oriented Programming)
- Collections (`HashMap`, `ArrayList`)
- Modularization (helper methods for cleaner logic)
- `Scanner` for input handling
- `LocalDateTime` for timestamping transactions

---

## 🧠 Concepts Practiced

This project was designed to consolidate and apply key Java concepts:

- Encapsulation and class composition
- Reusable logic and modular design
- Data structures for in-memory storage
- Defensive programming and basic validation
- Single Responsibility Principle through helper methods

---

## 🚀 Future Improvements

The current version provides a solid base for banking logic, but many enhancements can be introduced to make the system more robust and production-ready:

### 🧩 Code Architecture

- **Service Layer Separation**:  
  Introduce service classes like `CustomerService` and `BankService` to handle responsibilities and improve testability.

- **Exception Handling**:  
  Replace basic validation with custom exceptions to improve error flow control.

### 📈 Functional Enhancements

- **Data Persistence**:  
  Implement file-based saving (e.g., `.csv` or `.json`) or integrate a database (e.g., SQLite or MySQL) to store customer and account data between sessions.

- **Authentication System**:  
  Add secure login and password management for customers to protect access to their accounts.

- **Statement Export**:  
  Enable users to export account statements to PDF or text files.

- **Account Filtering**:  
  Display only active accounts during operations like transfers and withdrawals.

### 🖥️ UI/UX

- **Graphical User Interface**:  
  Build a GUI using JavaFX or Swing to make the system more user-friendly and accessible.

- **Validation Enhancements**:  
  Add better input validation for fields such as email, phone number, and NIF using regex.

### 🌍 Miscellaneous

- **Internationalization & Currency Support**:  
  Support multi-language messages and multiple currencies with exchange rates.

- **Testing & QA**:  
  Add unit tests using JUnit to validate methods and maintain code quality.

---

## ▶️ How to Run

1. **Compile the project**
   ```bash
   javac *.java
