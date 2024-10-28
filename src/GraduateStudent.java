// GraduateStudent.java
public class GraduateStudent extends Student {
    private String thesisTopic;
    private String advisorName;

    public GraduateStudent(String name, int age, double gpa, String thesisTopic, String advisorName) {
        super(name, age, gpa);
        this.thesisTopic = thesisTopic;
        this.advisorName = advisorName;
    }

    public void updateThesisTopic(String newTopic) {
        thesisTopic = newTopic;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis Topic: " + thesisTopic + ", Advisor: " + advisorName;
    }
}
