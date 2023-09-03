package chapater2;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private String course;
    private List<Student> students;

    public Teacher(String name, String course) {
        this.name = name;
        this.course = course;
        this.students = new ArrayList<Student>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public void teach(Student student) {
        this.students.add(student);
    }

    public void assignScore(String name, double score) {
        for (Student student : this.students) {
            if (student.getName().equals(name)) {
                student.setScore(this.getCourse(), score);
            }
        }
    }

    public void teachStudentsInRoom() {
        for (Student student : students) {
            String classRoom = "";
            for (Classroom classroom : student.getRoom() ) {
                if (classroom.getRoomid().indexOf(this.getCourse().toLowerCase()) >=0) {
                    String room = this.getCourse();
                    System.out.println(this.getName() + " teaches " + student.getName() + ", in classroom " + this.getCourse());
                } else {
                    System.out.println(this.getName() + " teaches " + student.getName());
                }
            }
        }
    }

}


