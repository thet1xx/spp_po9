public class StudentOfFaculty extends Student {
    private String faculty;

    public StudentOfFaculty(String name, int age, String faculty) {
        super(name, age);
        this.faculty = faculty;
    }

    @Override
    public void apply() {
        System.out.println(name + " подал заявку на поступление на факультет " + faculty);
    }

    @Override
    public void study() {
        System.out.println(name + " изучает предметы на факультете " + faculty);
    }

    @Override
    public void showInfo() {
        System.out.println("Студент: " + name + ", возраст: " + age + ", факультет: " + faculty);
    }
}
