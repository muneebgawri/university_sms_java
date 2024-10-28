// Student.java
public abstract class Student {
    private static int totalStudents = 0;
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private double gpa;
    private boolean isGraduated;

    public Student(String name, int age, double gpa) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.isGraduated = false;
        totalStudents++;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void markAsGraduated() {
        isGraduated = true;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa + ", Graduation Status: " + (isGraduated ? "Graduated" : "Not Graduated");
    }
}
