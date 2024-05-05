package Task1;

import Task1.Interfaces.StudentInterface;

import java.util.ArrayList;
import java.util.List;

public class Student implements StudentInterface {
    private String name;

    private List<LabWork> labWorks = new ArrayList<>();



    public Student(String name, int numberLabWorks) {
        this.name = name;
        for (int i = 1; i <= numberLabWorks; i++){
            this.labWorks.add(new LabWork(i));
        }
    }

    @Override
    public void doСonsultation() {
        System.out.println(name + " пришел на консультацию");
    }

    @Override
    public void doLection() {
        System.out.println(name + " пришел на лекцию");
    }

    @Override
    public void doExam() {
        System.out.println(name + " пришел на экзамен");
    }

    public String getName() {
        return name;
    }

    public List<LabWork> getLabWorks() {
        return labWorks;
    }
}
