package chapater4.practise1;

import java.util.ArrayList;
import java.util.List;

public class Contacts {
    private List<Student> phoneList = new ArrayList<Student>();
    public Contacts() {

    }
    public Contacts(List<Student> phoneList) {
        this.phoneList = phoneList;
    }
    public Student findPhoneNumber(String phoneNumber) {
        for(Student student: this.phoneList) {
            if (student.getPhone().equals(phoneNumber)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getPhoneList() {
        return this.phoneList;
    }
    public Student findName(String name) {
        for(Student student: this.phoneList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void addContact(Student student) {
        phoneList.add(student);
    }

    public static void main(String[] args) {
        Contacts contacts = new Contacts();
        contacts.test();

    }

    public void test() {
        Student charles = new Student("Charles", "male", 40);
        charles.setPhone("0465956");
        List<Student> studentList = new ArrayList<>();
        studentList.add(charles);
        Contacts contacts = new Contacts(studentList);

        Student zhangsan = new Student("Zhangsan", "male", 20);
        zhangsan.setPhone("0456584");
        Student lili = new Student("Lili", "female", 18);
        lili.setPhone("0456523");
        contacts.addContact(lili);
        contacts.addContact(zhangsan);
        System.out.println("List all the contacts again");
        for(Student student: contacts.getPhoneList()) {
            System.out.println("name: " + student.getName() + ", phone: " + student.getPhone());
        }

        //find name
        Student student1 =  contacts.findName("Charles");
        Student student2 = contacts.findName("Lili");
        //find phone
        Student student3 = contacts.findPhoneNumber("0465956");
        Student student4 = contacts.findPhoneNumber("0456584");

        student1.say();
        student2.say();
        student3.say();
        student4.say();

        //can not find the phone or name
        Student student5 = contacts.findName("Wangwu");
        Student student6 = contacts.findPhoneNumber("0415354");
        if ( student5==null) {
            System.out.println("Contacts can not find name Wangwu");
        }
        if ( student6 == null ) {
            System.out.println("Contacts can not find student phone number 0415354");
        }
    }
}
