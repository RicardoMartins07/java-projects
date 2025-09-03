# 📚 Virtual Library System

This is a **console-based virtual library system** developed in Java. It allows you to manage a collection of books, register users, and handle book loans in an intuitive and structured way.

## 📌 Features

- ✅ **Book Management**
    - Add new books to the library
    - Edit book details (title, author, ISBN, etc.)
    - Delete books
    - Search books by title or ISBN
    - List all books
    - Filter available books (not on loan)

- 🙋 **User Management**
    - Add new users
    - Edit user information
    - Delete users
    - Search users by name
    - List all users
    - Check a user’s current loans

- 🔄 **Loan System**
    - Allow users to loan available books
    - Mark books as returned
    - Prevent loaning books already on loan
    - Track each loan’s details (book, user, date)

---

## 🛠 Technologies Used

- Java 17+
- OOP (Object-Oriented Programming)
- Collections (`ArrayList`)
- Separation of concerns via `Service` classes
- `Scanner` for input handling
- `LocalDate` for loan dates

---

## 🧠 Concepts Practiced

This project reinforces key Java and software development concepts:

- Encapsulation and object composition
- Stream filtering and lambda expressions
- Modular code structure (single responsibility per method/class)
- Defensive programming and input validation
- Working with dates and dynamic lists

---

## 🚀 Future Improvements

Although functional, the system can be improved in several areas:

### 🧩 Architecture

- **Data Persistence**
    - Save books, users, and loans to file (e.g., JSON or CSV)
    - Load from file when the program starts
- **Serialization/Deserialization**
    - Allow saving/loading the complete object state

### 📈 Features

- **Loan Expiration**
    - Add return deadlines and track overdue books
- **Book Categories & Tags**
    - Allow filtering by genre or tags
- **User Loan History**
    - Show previously returned books

### 🖥️ UI/UX

- **GUI**
    - Add a graphical interface with JavaFX or Swing
- **Validation**
    - Improve field validation (e.g., valid email format)

### 🧪 Testing

- Add unit tests for core logic using **JUnit**
- Create mock data for testing purposes

---

## ▶️ How to Run

1. **Compile all Java files**
   ```bash
   javac *.java
