// Main.java

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUniversity Student Management System");
            System.out.println("1. Register a new student");
            System.out.println("2. Promote undergraduate student");
            System.out.println("3. Update GPA");
            System.out.println("4. Mark student as graduated");
            System.out.println("5. Display all students");
            System.out.println("6. View total and graduated student count");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> registerStudent(scanner);
                case 2 -> promoteStudent(scanner);
                case 3 -> updateGPA(scanner);
                case 4 -> markAsGraduated(scanner);
                case 5 -> displayAllStudents();
                case 6 -> displayStatistics();
                case 7 -> {
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Type of Student (Undergraduate/Graduate): ");
        String type = scanner.nextLine().toLowerCase();

        if (type.equals("undergraduate")) {
            System.out.print("Enter major: ");
            String major = scanner.nextLine();
            System.out.print("Enter year of study: ");
            int year = scanner.nextInt();
            students.add(new UndergraduateStudent(name, age, gpa, major, year));
        } else if (type.equals("graduate")) {
            System.out.print("Enter thesis topic: ");
            String thesisTopic = scanner.nextLine();
            System.out.print("Enter advisor name: ");
            String advisorName = scanner.nextLine();
            students.add(new GraduateStudent(name, age, gpa, thesisTopic, advisorName));
        } else {
            System.out.println("Invalid student type.");
        }
    }

    private static void promoteStudent(Scanner scanner) {
        System.out.print("Enter student ID to promote: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student instanceof UndergraduateStudent && student.getId() == id) {
                ((UndergraduateStudent) student).promote();
                System.out.println(student.getName() + " promoted to year " + ((UndergraduateStudent) student).getYear());
                return;
            }
        }
        System.out.println("Undergraduate student not found.");
    }

    private static void updateGPA(Scanner scanner) {
        System.out.print("Enter student ID to update GPA: ");
        int id = scanner.nextInt();
        System.out.print("Enter new GPA: ");
        double newGpa = scanner.nextDouble();
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGpa(newGpa);
                System.out.println(student.getName() + "'s GPA updated to " + newGpa);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void markAsGraduated(Scanner scanner) {
        System.out.print("Enter student ID to mark as graduated: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.getId() == id) {
                student.markAsGraduated();
                System.out.println(student.getName() + " marked as graduated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void displayStatistics() {
        System.out.println("Total students: " + Student.getTotalStudents());
        long graduatedCount = students.stream().filter(Student::isGraduated).count();
        System.out.println("Graduated students: " + graduatedCount);
    }
}
