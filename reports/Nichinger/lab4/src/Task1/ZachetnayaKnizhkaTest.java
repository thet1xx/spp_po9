package Task1;

import java.time.Year;
import Task1.ZachetnayaKnizhka.*;

public class ZachetnayaKnizhkaTest {
    public static void main(String[] args) {
        ZachetnayaKnizhka zk = new ZachetnayaKnizhka();

        Session session = new Session(Year.now(), Semester.SECOND);

        session.addExam(new Exam(Subject.PHYSICS, 10));
        session.addExam(new Exam(Subject.MATHEMATICS, 9));
        session.addZachet(new Zachet(Subject.HISTORY, 8));
        zk.addSession(session);

        System.out.println(zk);
    }
}
