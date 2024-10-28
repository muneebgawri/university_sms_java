// UndergraduateStudent.java
public class UndergraduateStudent extends Student {
    private String major;
    private int year;

    public UndergraduateStudent(String name, int age, double gpa, String major, int year) {
        super(name, age, gpa);
        this.major = major;
        this.year = year;
    }

    public void promote() {
        year++;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return super.toString() + ", Major: " + major + ", Year: " + year;
    }
}
