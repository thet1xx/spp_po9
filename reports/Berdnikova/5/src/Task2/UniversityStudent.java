public class UniversityStudent extends Student{
    private String university;
    private String faculty;
    public UniversityStudent(String name, int age, String university, String faculty){
        super(name, age);
        this.university = university;
        this.faculty = faculty;
    }

    @Override
    public void study() {

        System.out.println("UniStudent study at " + university + " University, at faculty of " + faculty);
    }

    @Override
    public String getIdentification() {
        return "University: " + university;
    }

    public String getFaculty(){
        return faculty;
    }

}
