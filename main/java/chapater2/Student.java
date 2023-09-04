package chapater2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private int id;
    private String name;
    private int age;
    private List<Classroom> studyroom;
    private Map<String, Double> scores;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        scores = new HashMap<String, Double>();
        studyroom = new ArrayList<>();
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }



    public void setRoom(Classroom room) {
        this.studyroom.add(room);
    }

    public List<Classroom> getRoom() {
        return this.studyroom;
    }

    public void setScore(String course, Double score) {
        scores.put(course, score);
    }

    public void getScores() {
        System.out.println(this.getName() + " gets courses result ");
        scores.forEach((key, value) -> System.out.println(key + " gets " + value));
    }

}
