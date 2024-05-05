package Task1;

import Task1.Interfaces.TeacherInterface;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements TeacherInterface {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }


    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void checkLabWorks(Student student) {
        System.out.println("Лабораторные работы " + student.getName());
        for (LabWork labWork : student.getLabWorks()){
            this.setMark(labWork, 9);
        }
    }

    @Override
    public void сonductСonsultation() {
        for (Student student : students){
            student.doСonsultation();
        }
        System.out.println("Провожу консультацию");
    }

    @Override
    public void сonductExam() {
        System.out.println("Провожу экзамен");
        for (Student student : students){
            student.doExam();
            if(student.getLabWorks().size() == 6){
                System.out.println("Студент " + student.getName() + " сдал экзамен");
            }else {
                System.out.println("Студент " + student.getName() + " не сдал экзамен");
            }
        }
    }

    @Override
    public void setMark(LabWork labWork, int mark) {
        labWork.setMark(mark);
        System.out.println("Проверяю лабораторную работу номер " + labWork.getNumber());
    }

    @Override
    public void сonductLection() {
        for (Student student : students){
            student.doLection();
        }
        System.out.println("Провожу лекцию");
    }
}
