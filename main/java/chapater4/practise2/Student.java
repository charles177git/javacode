package chapater4.practise2;

public class Student extends Common {
    private String courses[];
    public Student(String name, int age, String gender) {
        super(name, age, gender);
    }

    protected void addCourse(String course) {
        this.courses[this.courses.length] = course;
    }
    protected String[] getCourse() {
        return this.courses;
    }
}
