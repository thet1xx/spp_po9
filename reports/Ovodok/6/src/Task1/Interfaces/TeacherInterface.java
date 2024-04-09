package Task1.Interfaces;

import Task1.LabWork;
import Task1.Student;

import java.util.List;

public interface TeacherInterface {
    List<Student> getStudents();
    public void checkLabWorks(Student student);
    public void сonductСonsultation();
    public void сonductExam();
    public void setMark(LabWork labWork, int mark);
    public void сonductLection();


}
