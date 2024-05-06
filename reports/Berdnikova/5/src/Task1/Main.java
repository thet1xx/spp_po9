public class Main {
    public static void main(String[] args) {
        Abiturient abiturient1 = new StudentOfFaculty("Студент1", 18, "Факультет1");
        Student student1 = new StudentOfFaculty("Студент2", 20, "Факультет2");

        Abiturient[] abiturients = {abiturient1};
        Student[] students = {student1};

        for (Abiturient abiturient : abiturients) {
            abiturient.apply();
        }

        for (Student student : students) {
            student.study();
            student.showInfo();
        }
    }
}