# University Student Management System (Java)

## Overview

This Java project provides a University Student Management System to track and manage student information. It employs object-oriented programming principles like encapsulation and inheritance.

### Project Structure

- `Main.java`: The main program with a menu for staff to manage students.
- `Student.java`: The base `Student` class, with fields common to all students.
- `UndergraduateStudent.java`: `UndergraduateStudent` class for undergraduate students, adding fields like `major` and `year`.
- `GraduateStudent.java`: `GraduateStudent` class for graduate students, adding fields like `thesisTopic` and `advisorName`.

## How to Run

1. Compile all Java files:
   ```
   javac src/*.java
   ```

2. Run the main program:
   ```
   java -cp src Main
   ```

## License

This project is licensed under the MIT License.
