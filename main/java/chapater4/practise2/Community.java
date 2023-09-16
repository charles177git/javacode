package chapater4.practise2;

import java.util.ArrayList;
import java.util.List;

public class Community {
    public static void main(String[] args) {
        Community community = new Community();
        community.test();

    }

    public void test() {
        Common charles = new Common("Charles", 40, "male");
        System.out.println(charles.toString());
        if (charles instanceof Common) {
            System.out.println("charles is in the common class");
        }
        Student huazhen = new Student("Huazhen" , 18, "male");
        Student zhangsan = new Student("zhangsan" , 19, "male");

        School centerSchool = new School("CenterSchool");
        centerSchool.setSchoolAddress("100 Bridge Road, Harbour, NSW");
        centerSchool.addStudent(huazhen);
        centerSchool.addStudent(zhangsan);
        String[] studentsName = centerSchool.getStudent();

        for (int i=0; i< studentsName.length; i++) {
            if (studentsName[i]!= null) {
                System.out.println(studentsName[i] + " studies in " + centerSchool.getSchoolName()+ ", at " + centerSchool.getSchoolAddress());
            }
        }
        if (zhangsan instanceof Common && zhangsan instanceof Student) {
            System.out.println("zhangsan is one of student class object");
        }

        Teacher zhao = new Teacher("Zhao", 55, "male", "Chemistry");
        Teacher wang = new Teacher("Wang", 60, "female", "Chemistry");
        Teacher li = new Teacher("Li", 57, "female", "Physics");

        MasterTeacher tao = new MasterTeacher("Tao", 58, "male", "Chinese", "G32");

        List<Teacher> lists = new ArrayList<>();
        lists.add(wang);
        lists.add(zhao);
        lists.add(li);
        lists.add(tao);

        centerSchool.addTeacher(wang);
        centerSchool.addTeacher(zhao);
        centerSchool.addTeacher(li);
        centerSchool.addTeacher(tao);

        String[] teachersName = centerSchool.getTeacher();
        for (int j = 0; j< teachersName.length; j++) {
            if (teachersName[j]!= null && lists.get(j).getName().equals(teachersName[j])) {
                System.out.println(teachersName[j] + " teaches in " +  centerSchool.getSchoolName()+ ", and teaches " + lists.get(j).getCourse() + " at " + centerSchool.getSchoolAddress());
                if (lists.get(j) instanceof MasterTeacher && ((MasterTeacher)lists.get(j)).getClasses() != null ) {
                    System.out.println(teachersName[j] + "is an master teach for class " + ((MasterTeacher)lists.get(j)).getClasses());
                }
            }
        }


    }
}
