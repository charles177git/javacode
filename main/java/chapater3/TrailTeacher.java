package chapater3;

import chapater4.practise2.Teacher;

public class TrailTeacher extends Teacher {
    public TrailTeacher(String name, int age, String gender, String course) {
        super(name, age, gender, course);
    }

    public void test() {
        //in another package to access parent class Teacher's protected method
        //in another package can not access Teacher's protected method, that is the main different between protected method with friend method.
        this.setStationary("ruler");
        System.out.println(this.getName() + " likes " + this.getHobby() + ", he has "+ this.getStationary()+" as stationary tool");
        //can set course, this is a public method
        this.setCourse("High level match");
        //this is wrong, getCourse is a friend method, so can not access friend method.
//        this.getCourse();

    }
    public static void main(String[] args) {
        TrailTeacher trailTeacher = new TrailTeacher("Teacher Sun", 24, "male", "Math");
        trailTeacher.test();
    }
}
