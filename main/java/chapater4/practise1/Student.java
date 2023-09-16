package chapater4.practise1;

public class Student {
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private String email;
    public Student() {

    }
    public Student(String name, String gender, int age) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    protected String getGender() {
        return gender;
    }

    protected int getAge() {
        return age;
    }

    public void eat() {
        System.out.println("I eat a lot of food");
    }
    public  void sleep() {
        System.out.println("I like sleep in bed");
    }

    public void play() {
        System.out.println("I like play soccer");

    }

    public void drink() {
        System.out.println("I prefer tea rather then coff");
    }



    public static void main(String[] args) {
        Student student = new Student("Charles", "male", 40);
        student.eat();
        student.drink();
        student.sleep();
        student.play();
        student.setEmail("charles@gmail.com");
        student.setPhone("04034344");
        student.setAddress("4 Mary Street, Lidcombe, NSW");
        System.out.println(student.getEmail());
        System.out.println(student.getPhone());
        System.out.println(student.getAddress());
        student.say();

    }
    protected void setEmail(String email) {
        this.email = email;
    }
    protected void setPhone(String phone) {
        this.phone = phone;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected String getName(){
        return name;
    }

    protected String getEmail() {
        return email;
    }

    protected String getPhone() {
        return this.phone;
    }

    protected String getAddress() {
        return this.address;
    }

    protected void say() {
      System.out.println("name " +getName() + ", gender " + getGender() + ", age " + getAge() + ", phone " + getPhone());
    }

}
