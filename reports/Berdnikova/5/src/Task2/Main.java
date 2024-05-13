public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new SchoolStudent("John", 15, 9);
        students[1] = new SchoolStudent("Mary", 14, 8);
        students[2] = new UniversityStudent("Peter", 20, "MSU", "Computer Science");

        System.out.println("School Students:");
        for (Student student : students) {
            if (student instanceof SchoolStudent) {
                System.out.println(student.getName() + ", age " + student.getAge() + ", " + student.getIdentification());
                student.study();
            }
        }

        System.out.println("\nUniversity Students:");
        for (Student student : students) {
            if (student instanceof UniversityStudent) {
                System.out.println(student.getName() + ", age " + student.getAge() + ", " + student.getIdentification());
                student.study();
            }
        }
    }
}