package chapater2;

public class School {
    public static void main(String[] args) {
        School school = new School();
        school.test();
    }

    public void test() {
        Classroom chemistryroom = new Classroom("chemistry001", 50);
        Classroom physicsroom = new Classroom("physics001", 30);
        Student charles = new Student(10, "Charles");
        Student huazhen = new Student(20, "Huazhen");
        charles.setAge(48);
        huazhen.setAge(18);
        System.out.println(charles.getName() + ", age "+charles.getAge());
        System.out.println(huazhen.getName() + ", age "+huazhen.getAge());


        Teacher zhao = new Teacher("Zhao", "Chemistry");
        Teacher wang = new Teacher("Wang" , "Physics");

        zhao.teach(charles);
        zhao.teach(huazhen);

        wang.teach(charles);
        wang.teach(huazhen);

        zhao.assignScore("Charles", 80.2);
        zhao.assignScore("Huazhen", 99);

        wang.assignScore("Charles", 90.3);
        wang.assignScore("Huazhen", 98.3);

        charles.getScores();
        huazhen.getScores();

        charles.setRoom(physicsroom);
        huazhen.setRoom(physicsroom);

        charles.setRoom(chemistryroom);
        huazhen.setRoom(chemistryroom);

        wang.teachStudentsInRoom();
        zhao.teachStudentsInRoom();

    }
}
