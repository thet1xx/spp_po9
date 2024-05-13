import java.util.ArrayList;
import java.util.Random;

public class ZachetnayaKnizhka {
    private ArrayList<Session> sessions;
    private ArrayList<Exam> exams;
    private ArrayList<Zachet> zachets;
    private Random random;

    public ZachetnayaKnizhka() {
        this.sessions = new ArrayList<>();
        this.exams = new ArrayList<>();
        this.zachets = new ArrayList<>();
        this.random = new Random();
    }

    public void addSession() {
        int course = random.nextInt(4) + 1; // Генерируем случайное число от 1 до 4
        String[] sessionTypes = {"Winter", "Summer"};
        String sessionType = sessionTypes[random.nextInt(sessionTypes.length)]; // Случайный выбор из списка типов сессии
        sessions.add(new Session(course, sessionType));
    }

    public void addExam() {
        String[] subjects = {"Math", "Physics", "Chemistry", "Biology"};
        String subject = subjects[random.nextInt(subjects.length)]; // Случайный выбор из списка предметов
        int grade = random.nextInt(11); // Генерируем случайную оценку от 0 до 10
        exams.add(new Exam(subject, grade));
    }

    public void addZachet() {
        String[] subjects = {"History", "Literature", "Geography", "Languages"};
        String subject = subjects[random.nextInt(subjects.length)]; // Случайный выбор из списка предметов
        int grade = random.nextInt(11); // Генерируем случайную оценку от 0 до 10
        zachets.add(new Zachet(subject, grade));
    }

    public void printSessions() {
        System.out.println("Sessions:");
        for (Session session : sessions) {
            System.out.println(session);
        }
    }

    public void printExams() {
        System.out.println("Exams:");
        for (Exam exam : exams) {
            System.out.println(exam);
        }
    }

    public void printZachets() {
        System.out.println("Zachets:");
        for (Zachet zachet : zachets) {
            System.out.println(zachet);
        }
    }

    class Session {
        private int course;
        private String sessionType;

        public Session(int course, String sessionType) {
            this.course = course;
            this.sessionType = sessionType;
        }

        @Override
        public String toString() {
            return "Course: " + course + ", Session Type: " + sessionType;
        }
    }

    class Exam {
        private String subject;
        private int grade;

        public Exam(String subject, int grade) {
            this.subject = subject;
            this.grade = grade;
        }

        @Override
        public String toString() {
            String status = (grade >= 4) ? "Passed" : "Failed";
            return "Subject: " + subject + ", Grade: " + grade + ", Status: " + status;
        }
    }

    class Zachet {
        private String subject;
        private int grade;

        public Zachet(String subject, int grade) {
            this.subject = subject;
            this.grade = grade;
        }

        @Override
        public String toString() {
            String status = (grade >= 4) ? "Passed" : "Failed";
            return "Subject: " + subject + ", Grade: " + grade + ", Status: " + status;
        }
    }

    public static void main(String[] args) {
        ZachetnayaKnizhka book = new ZachetnayaKnizhka();
        book.addSession();
        book.addExam();
        book.addZachet();

        book.printSessions();
        book.printExams();
        book.printZachets();
    }
}
