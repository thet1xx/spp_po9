package Task1;

public class Main{
    public static void main(String[] args) {
        Student student1 = new Student("Вадим", 6);
        Student student2 = new Student("Леша", 3);

        Teacher teacher = new Teacher();
        teacher.addStudent(student1);
        teacher.addStudent(student2);

        teacher.сonductLection();

        teacher.checkLabWorks(student1);
        teacher.checkLabWorks(student2);

        teacher.сonductСonsultation();
        teacher.сonductExam();

    }
}
