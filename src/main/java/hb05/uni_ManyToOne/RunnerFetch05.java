package hb05.uni_ManyToOne;

import hb05.uni_ManyToOne.University;
import hb05.uni_ManyToOne.Student05;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch05 {
    public static void main(String[] args) {
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).
                addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        System.out.println("======Using get() fetch students=======");
//        Student03 student01 = session.get(Student03.class, 1022);
//
//
//        Diary diary1 = session.get(Diary.class, 2001);
//        System.out.println(diary1);
//
//        System.out.println(diary1.getStudent03());// will get the student associated with diary1

//        Student05 student03 = session.get(Student05.class, 5001);
//        System.out.println(student03);
//
//        University university = session.get(University.class, 1001);
//        System.out.println(university);

        // Fetch students who universities id is 1000

        String Hql01 = "FROM Student05 s WHERE s.university.id = 1000";
        List<Student05> studentList05 = session.createQuery(Hql01, Student05.class).getResultList();
        studentList05.forEach(s -> System.out.println(s));


        tx.commit();
        session.close();
        sf.close();



    }


}
