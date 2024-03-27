package Task1;

import java.time.Year;
import java.util.ArrayList;

/*
TODO Реализовать указанный класс, включив в него вспомогательный внутренний класс или классы.
     Реализовать 2-3 метода (на выбор). Продемонстрировать использование реализованных классов.

TODO Создать класс Зачетная Книжка с внутренним классом, с помощью объектов которого можно
     хранить информацию о сессиях, зачетах, экзаменах
 */
public class ZachetnayaKnizhka {
    private ArrayList<Session> sessions;
    public ZachetnayaKnizhka(){
        sessions = new ArrayList<>();
    }
    public void addSession(Session session){
        if (session != null){
            for (Session ses : sessions){
                if (ses.getYear() == session.getYear()
                        && ses.getSemester() == session.getSemester())
                    break;
            }
            sessions.add(session);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("сессии:\n");
        for (Session session : sessions) {
            stringBuilder.append(session).append("\n");
        }
        return stringBuilder.toString();
    }

    public enum Semester {
        FIRST("первый семестр"), SECOND("второй семестр");
        private final String name;
        Semester(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        @Override
        public String toString() {
            return name;
        }
    }

    public enum Subject {
        MATHEMATICS("математика"), PHYSICS("физика"), HISTORY("история"),
        MODERN_PROGRAMMING_PLATFORMS("соременные платформы програмиирования");
        private final String name;
        Subject(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class Session {
        private ArrayList<Exam> exams;
        private ArrayList<Zachet> zachets;
        private Year year;
        private Semester semester;
        {
            this.exams = new ArrayList<>();
            this.zachets = new ArrayList<>();
            year = Year.now();
            semester = Semester.FIRST;
        }
        public Session(Year year, Semester semester){
            this.year = year;
            this.semester = semester;
        }
        public void addExam(Exam exam){
            if (exam != null){
                for (Exam ex : exams){
                    if (ex.getSubject() == exam.getSubject())
                        break;
                }
                exams.add(exam);
            }
        }
        public void addZachet(Zachet zachet){
            if (zachet != null){
                for (Zachet zach : zachets){
                    if (zach.getSubject() == zachet.getSubject())
                        break;
                }
                zachets.add(zachet);
            }
        }
        public Year getYear() {
            return year;
        }
        public void setYear(Year year) {
            this.year = year;
        }
        public Semester getSemester() {
            return semester;
        }
        public void setSemester(Semester semester) {
            this.semester = semester;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("сессия ").append(year).append(" ").append(semester).append(":");
            stringBuilder.append("\n\tэкзамены:");
            for (Exam exam : exams){
                stringBuilder.append("\n\t\t").append(exam);
            }
            stringBuilder.append("\n\tзачёты:");
            for (Zachet zachet : zachets) {
                stringBuilder.append("\n\t\t").append(zachet);
            }
            return stringBuilder.toString();
        }
    }

    public static class KnowledgeAssessment {
        private Subject subject;
        private int mark;
        private KnowledgeAssessment(){}
        public KnowledgeAssessment(Subject subject, int mark){
            this.subject = subject;
            this.mark = (mark >= 1 && mark <= 10) ? mark : 1;
        }
        public void setMark(int mark) {
            if (mark >= 1 && mark <= 10)
                this.mark = mark;
        }
        public int getMark() {
            return mark;
        }
        public void setSubject(Subject subject) {
            this.subject = subject;
        }
        public Subject getSubject() {
            return subject;
        }
        public String getSubjectName() {
            return subject.getName();
        }

        @Override
        public String toString() {
            return subject + ": оценка " + mark;
        }
    }

    public static class Exam extends KnowledgeAssessment {
        private Exam(){}
        public Exam(Subject subject, int mark){
            super(subject, mark);
        }
    }

    public static class Zachet extends KnowledgeAssessment {
        private Zachet(){}
        public Zachet(Subject subject, int mark){
            super(subject, mark);
        }
    }
}