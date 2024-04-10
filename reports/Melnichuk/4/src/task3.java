import java.util.ArrayList;
import java.util.List;

class Elective{
    private String name;
    private Teacher teacher;
    private List<Student> students;
    private Course course;

    public Elective(String name, Teacher teacher, Course course){
        this.name = name;
        this.teacher = teacher;
        this.course = course;
        students = new ArrayList<>();
    }

    public void registration(Student student){
        students.add(student);
    }

    public void learning(){
        System.out.println("Обучение на факультативе " + name + " началось.");
    }

    public void finish(){
        System.out.println("Обучение на факультативе " + name + " завершено.");
    }

}

class Teacher{
    private String name;

    public Teacher(String name){
        this.name = name;
    }
    public void advertReg(Course course){
        System.out.println("Запись на курс \"" + course.getName() + "\" объявлена преподавателем " + name + ".");
    }

    public void setMark(Student student, int mark){
        Archive.saveMark(student, mark);
        System.out.println("Оценка " + mark + " выставлена " + student.getName());
    }
}

class Student{
    private int id;
    private String name;

    public Student(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public void registration(Course course){
        System.out.println("Студент " + name + " записался на курс " + Course.getName());
    }

    public String getName(){
        return name;
    }
}

class Course {
    private static String name;

    public Course(String name){
        this.name = name;
    }
    public static String getName(){
        return name;
    }
}

class Archive{
    private static List<String> marks;

    static {
        marks = new ArrayList<>();
    }
    public static void saveMark(Student student, int mark){
        marks.add("Студент " + student.getName() + ": Оценка " + mark);
    }

    public List<String> getMarks(){
        return marks;
    }
}
public class task3{
    public static void main(String[] args){
         Course course = new Course("Математика");
         Archive marks = new Archive();

         Teacher teacher = new Teacher("Иванченко А.В.");
         teacher.advertReg(course);

         Elective elective = new Elective("Факультатив по математике", teacher, course);

         Student student1 = new Student(210663, "Melenkov");
         Student student2 = new Student(210664, "Molankova");

         elective.registration(student1);
         elective.registration(student2);

         student1.registration(course);
         student2.registration(course);

         elective.learning();
         elective.finish();
         teacher.setMark(student1, 4);
         teacher.setMark(student2, 5);
        List<> archives = marks.getMarks();
         for(Object archive : archives){
             System.out.println();
         }

    }
}
