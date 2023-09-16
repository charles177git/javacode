package chapater4.practise2;

class School {
    private String name;
    private String address;
    private String[] studentsName;
    private String[] teachersName;
    public School(String name) {
        this.name = name;
        studentsName = new String[20];
        teachersName = new String[20];

    }

    protected String getSchoolName() {
        return this.name;
    }

    protected String getSchoolAddress() {
        return this.address;
    }

    protected void setSchoolAddress(String address) {
        this.address = address;
    }
    protected void addStudent(Student student) {
        for (int j=0; j< studentsName.length; j++) {
            if (this.studentsName[j] == null) {
                this.studentsName[j] = student.getName();
                break;
            }
        }
    }
    protected String[] getStudent() {
        return this.studentsName;
    }
    protected void addTeacher(Teacher teacher) {
        for (int j=0; j< teachersName.length; j++) {
            if (teachersName[j] == null){
                this.teachersName[j] = teacher.getName();
                break;
            }
        }
    }
    protected String[] getTeacher() {
        return this.teachersName;
    }

}
