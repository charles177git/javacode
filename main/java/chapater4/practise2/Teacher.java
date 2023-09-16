package chapater4.practise2;

public class Teacher extends Common{
    private String name;
    private String gender;
    private int age;
    protected String course;
    String stationary;
    public Teacher(String name, int age, String gender, String course){
        super(name, age, gender);
        this.course = course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    //friend function.
    String getCourse() {
        return this.course;
    }
    public String  getCar() {
        setCar("Cherry");
        return this.car;
    }
    protected String getHobby() {
        setHobby("Volleyball");
        return this.hobby;
    }
    protected void setStationary(String stationary) {
        this.stationary = stationary;
    }
    protected String getStationary() {
        return this.stationary;
    }
}
