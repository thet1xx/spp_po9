import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TeacherEventNotifier {
    Map<String, List<TeacherEventListener>> students = new HashMap<>();

    public TeacherEventNotifier(String... events) {
        for (String event : events) {
            this.students.put(event, new ArrayList<>());
        }
    }

    public void subscribe (String event, TeacherEventListener student) {
        List<TeacherEventListener> subscribers = students.get(event);
        subscribers.add(student);
    }

    public void unsubscribe (String event, TeacherEventListener student) {
        List<TeacherEventListener> subscribers = students.get(event);
        subscribers.remove(student);
    }

    public void notify (String event) {
        List<TeacherEventListener> subscribers = students.get(event);
        for (TeacherEventListener student : subscribers) {
            student.update(event);
        }
    }
}

class Teacher {
    public TeacherEventNotifier events;

    public Teacher () {
        this.events = new TeacherEventNotifier("reviewLabwork", "holdConsultation",
                "takeExam", "putGrade", "holdLecture");
    }

    void reviewLabwork () {
        events.notify("reviewLabwork");
    }

    void holdConsultation () {
        events.notify("holdConsultation");
    }

    void takeExam () {
        events.notify("takeExam");
    }

    void putGrade () {
        events.notify("putGrade");
    }

    void holdLecture () {
        events.notify("holdLecture");
    }
}

interface TeacherEventListener {
    void update(String eventType);
}

class Student implements TeacherEventListener {
    @Override
    public void update(String eventType) {
        System.out.println("The teacher has interacted with the student. " +
                "The following event occured: " + eventType);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.events.subscribe("reviewLabwork", new Student());
        teacher.events.subscribe("reviewLabwork", new Student());
        teacher.events.subscribe("holdConsultation", new Student());
        teacher.events.subscribe("takeExam", new Student());
        teacher.events.subscribe("putGrade", new Student());
        teacher.events.subscribe("putGrade", new Student());
        teacher.events.subscribe("holdLecture", new Student());

        teacher.takeExam();
        teacher.holdConsultation();
        teacher.holdLecture();
        teacher.reviewLabwork();
        teacher.putGrade();
    }
}