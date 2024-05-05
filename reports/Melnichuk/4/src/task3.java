import java.util.ArrayList;
import java.util.List;

class Elective{
    private String name;
    private Teacher teacher;
    private List<Student> students;

    public Elective(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    public void registration(Student student){
        students.add(student);
    }
    public String getName(){
        return name;
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
    public void advertReg(Elective elective){
        System.out.println("Запись на курс \"" + elective.getName() + "\" объявлена преподавателем " + name + ".");
    }

    public void setMark(Student student, int mark, Elective elective){
        Archive.saveMark(student, mark, elective);
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

    public void registration(Elective elective){
        elective.registration(this);
        System.out.println("Студент " + name + " записался на курс " + elective.getName());
    }

    public String getName(){
        return name;
    }
}

class Archive{
    private static List<String> marks;

    public Archive() {
        marks = new ArrayList<>();
    }
    public static void saveMark(Student student, int mark, Elective elective){
        marks.add("Студент: " + student.getName() + ", Курс: " + elective.getName() +  ", Оценка: " + mark);
    }

    public List<String> getMarks(){
        return marks;
    }
}
public class task3{
    public static void main(String[] args){
         Teacher teacher = new Teacher("Иванченко А.В.");
         Teacher teacher1 = new Teacher("Василенко В.Д.");

         Elective elective = new Elective("Математика", teacher);
         Elective elective1 = new Elective("Физика", teacher1);
         Archive archive = new Archive();

         teacher.advertReg(elective);
         teacher1.advertReg(elective1);

         Student student1 = new Student(210663, "Melenkov");
         Student student2 = new Student(210664, "Molankova");

         student1.registration(elective);
         student2.registration(elective);

         student1.registration(elective1);
         student2.registration(elective1);

         elective.learning();
         elective1.learning();
         elective.finish();
         elective1.finish();

         teacher.setMark(student1, 4, elective);
         teacher1.setMark(student1, 2, elective1);

         teacher.setMark(student2, 5, elective);
         teacher1.setMark(student2, 3, elective1);

         List<String> marks = archive.getMarks();
         for(String mark : marks){
             System.out.println(mark);
         }
    }
}

