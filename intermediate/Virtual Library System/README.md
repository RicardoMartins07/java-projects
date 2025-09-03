📚 Virtual Library System

A simple Virtual Library System developed in Java that allows you to manage books, users, and loans through a console-based interface. It simulates real-world library operations like registering books and users, borrowing books, and returning them.

🚀 Features
📖 Book Management

Add new books

Edit book details

Delete books

Search books by title or ISBN

List all books

👤 User Management

Register new users

Edit user details

Delete users

Search users by name

List all users

Check user's loan history

📗 Loan Management

Loan a book to a specific user

Mark a book as returned

View which books are currently on loan

Prevent loaning books that are already on loan

📁 Project Structure
.
├── Model/
│   ├── Book.java
│   ├── User.java
│   └── Loan.java
├── Service/
│   ├── LibraryService.java
│   ├── UserService.java
│   └── LoanService.java
├── Main.java

🛠️ Technologies Used

Java 17+

OOP Principles

Collections (List)

Java Streams & Lambdas

Scanner for user input

LocalDate for managing dates

🔮 Future Improvements

✅ Data Persistence

Save/load data using JSON or CSV files using libraries like Gson or Jackson.

Automatically load state on app start and save on exit.

⭐ Favorites or Book Ratings

Allow users to rate or mark favorite books.

📅 Loan Due Dates

Add due dates to loans and highlight overdue books.

📊 Statistics

Most borrowed books

Active users

🔍 Advanced Search

Filter by author, year, or genre.

🧪 Unit Tests

JUnit tests for service classes

🧑‍💻 How to Run

Clone the repository:

git clone https://github.com/yourusername/virtual-library-system.git


Open in your IDE (IntelliJ, Eclipse, etc.)

Run Main.java