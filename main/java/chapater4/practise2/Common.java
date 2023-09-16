package chapater4.practise2;

public class Common {
    private String name;
    private int age;
    private String gender;
    protected String hobby;
    private String toy;
    String car;
    public Common(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    protected void setHobby(String hobby) {
        this.hobby = hobby;
    }
    void setCar(String car) {
        this.car = car;
    }
    public String toString() {
        String statement = "name " + getName() + ", age " + getAge() + ", gender " + getGender();
        return statement;
    }

}
