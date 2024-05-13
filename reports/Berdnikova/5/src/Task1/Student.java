abstract public class Student implements Abiturient {
    protected String name;
    protected int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void study();

    public abstract void showInfo();
}


