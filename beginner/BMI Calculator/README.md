# 🧮 BMI Calculator (Beginner Project)

This is a simple command-line Body Mass Index (BMI) calculator written in Java.  
It asks the user for weight and height, supports both metric and imperial units, and classifies the result.

## ✅ Features

- User chooses between kilograms or pounds
- Inputs weight and height
- Calculates BMI using the appropriate formula:
    - `BMI = weight / (height * height)` for kg/m
    - `BMI = (weight * 703) / (height * height)` for lbs/inches
- Outputs BMI value and weight category:
    - Underweight
    - Normal weight
    - Overweight
    - Obese
- Validates invalid or negative inputs
- Allows only valid unit selections via menu loop

## 🧠 Java Concepts Practiced

- `Scanner` for user input
- `if` / `switch` control flow
- Method creation and reuse
- `do-while` loop for input validation
- Floating point arithmetic
- `printf` formatting
- Modular logic with helper methods

## 🚀 How to Run

1. Clone or download the project.
2. Open it in IntelliJ (or any Java IDE).
3. Run the `Main` class.

Alternatively, using terminal:

```bash
javac Main.java
java Main
