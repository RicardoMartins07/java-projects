# 📇 Contact Manager (Java Console Application)

A simple Java console-based application that allows users to manage contacts with **file persistence**. This app is ideal for beginners looking to practice object-oriented programming, file handling, and modular Java design.

---

## 🚀 Features

- ✅ Add a new contact
- ✅ Search contacts by **name**
- ✅ Search contacts by **phone number**
- ✅ Edit a contact
- ✅ Delete a contact
- ✅ List all contacts
- ✅ List all contacts ordered alphabetically by name
- ✅ Automatically saves contacts to a text file (`Contacts.txt`)

---

## 📁 Project Structure

```
src/
├── Main.java                  # Entry point of the application
├── Model/
│   └── Contact.java           # Data model representing a contact
├── Service/
│   └── ContactService.java    # Business logic for managing contacts
└── Util/
    └── FileUtils.java         # File import/export utility class
```

---

## 🗂️ Data Format: `Contacts.txt`

Each line in the file represents a contact in the following format:

```
Name - PhoneNumber - Email - Address
```

**Example:**

```
John Doe - 987654321 - john.doe@email.com - 123 Main Street
```

If the file doesn't exist at startup, it will be created automatically.

---

## 💡 How to Run

1. Make sure you have Java 17+ installed.
2. Clone or copy the source files to your computer.
3. Open the project using your preferred Java IDE (IntelliJ, Eclipse, VS Code, etc.).
4. Run the `Main.java` file.

---

## 📌 Menu Example

```
============== Contact Manager ================
1 - Enter a new Contact
2 - Search By name
3 - Search By Phone Number
4 - Edit Contact
5 - List All Contacts
6 - List All Contacts Ordered by name
7 - Delete Contact
0 - Quit
```

---

## 🛠️ Planned Improvements

- [ ] Export contacts to **JSON** format
- [ ] Mark contacts as **favorites**
- [ ] Export contacts to **CSV** format
- [ ] Maintain a **history** of all CRUD operations
- [ ] Add **unit tests** for core logic

---

## 🎯 Learning Goals

This project is great for practicing:

- Object-Oriented Programming (OOP)
- File handling and persistence
- Input validation and error handling
- Modular and layered Java code structure
- Working with lists and streams

---
