package chapater4.practise2;

public class MasterTeacher extends Teacher {
    private String classes;

    public MasterTeacher(String name, int age, String gender, String course, String classes) {
        super(name,  age, gender, course);
        this.classes = classes;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    protected String getClasses() {
        return  this.classes;
    }

}
