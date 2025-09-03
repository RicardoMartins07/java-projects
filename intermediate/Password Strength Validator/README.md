# 🔐 Password Validator

A simple console-based password validator developed in Java.  
It helps users verify if a password meets common security standards such as length, character variety, and complexity.

## 📌 Features

- ✅ **Password Requirements Check**
    - Minimum of 8 characters
    - At least 1 uppercase letter
    - At least 1 lowercase letter
    - At least 1 digit (0-9)
    - At least 1 special character (e.g., `!@#$%&*`)

- 🧠 **Regex Character Validation**
    - All Regex Methods are present in PasswordValidator Class.

- 🔁 **Retry Prompt**
    - After entering a password, users can try again or exit the program.

- 📋 **Detailed Feedback**
    - For each requirement, the system prints whether it passed or failed.

---

## 🛠 Technologies Used

- Java 17+
- Console I/O (`Scanner`)
- Static Utility Methods
- Control Flow and Loops
- `Character` Class Utilities
- Boolean Logic and Conditions

---

## 🧠 Concepts Practiced

- Modular and reusable method design
- Use of static utility methods
- Password validation logic and pattern recognition
- User input validation and feedback
- Encapsulation of logic per rule
- Clean terminal-based interaction

---

## 🚀 Future Improvements

### 🧩 Code & Architecture

- **External Configuration:**  
  Allow validation rules (e.g. min length, symbols allowed) to be defined in a config file or class.

- **Logging Support:**  
  Log attempts and results to a file for audit or debug purposes.

### 🖥️ UI/UX

- **Graphical Interface:**  
  Add a simple Swing or JavaFX window for entering passwords.

- **Color-coded Feedback:**  
  Use libraries to add colored output to terminal (for pass/fail rules).

### 🔒 Security Considerations

- **No Echo Input:**  
  Mask password input (using console mode or JavaFX).

- **Prevent Buffer Leak:**  
  Extend to support secure password handling in memory for real applications.

---

## ▶️ How to Run

1. **Compile the project:**
   ```bash
   javac Main.java PasswordValidator.java
