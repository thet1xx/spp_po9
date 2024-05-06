public class SchoolStudent extends Student {
    private int grade;

    public SchoolStudent(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void study() {
        System.out.println("SchoolStudent study in grade " + grade + ".");
    }

    @Override
    public String getIdentification() {
        return "Grade " + grade;
    }

    public int getGrade(){
        return grade;
    }
}
