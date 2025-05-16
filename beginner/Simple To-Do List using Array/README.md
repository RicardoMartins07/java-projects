# 📝 Java To-Do List (CLI Version)

A command-line Java application that allows you to create, manage, and update tasks efficiently using simple text-based interaction.  
Each task has a description, priority level, and category. You can edit, complete or delete tasks by ID.

---

## 🚀 Features

- ✅ Add new tasks with:
    - Description
    - Priority: `LOW`, `MEDIUM`, `HIGH`
    - Category: `PERSONAL`, `WORK`, `STUDY`, `SHOPPING`, `OTHER`
- 📃 List all tasks
- ✔️ Mark tasks as completed
- 🗑️ Delete tasks by ID
- ✏️ Edit existing tasks
- 🔐 Robust input validation and clean CLI interaction

---

## 🛠️ Tech Stack

- **Java 17+**
- `Scanner` for CLI input
- `ArrayList` for dynamic task storage
- `Enum` for type-safe values
- `LocalDate` for timestamps
- Object-Oriented Programming principles (OOP)

---

## 🧱 Folder Structure

Simple To-Do List ussing Array/
├── Main.java // Application logic & menu
├── Task.java // Task model class
├── Category.java // Enum for task category
├── Priorities.java // Enum for task priority
└── README.md // Project documentation
---

## 📦 How to Run

### 🖥️ With IntelliJ or Eclipse

1. Open the project in your IDE.
2. Run `Main.java`.

### 💻 From the terminal

```bash
javac *.java
java Main
