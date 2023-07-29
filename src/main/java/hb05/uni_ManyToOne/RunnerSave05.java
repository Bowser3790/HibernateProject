package hb05.uni_ManyToOne;

import hb03.oneToOne.Diary;
import hb03.oneToOne.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {
        Student05 student01 = new Student05();
        student01.setId(5000);
        student01.setName("Sushi");
        student01.setGrade(90);

        Student05 student06 = new Student05();
        student06.setId(5001);
        student06.setName("Turkey");
        student06.setGrade(80);

        Student05 student02 = new Student05();
        student02.setId(5002);
        student02.setName("Ham");
        student02.setGrade(70);


        University university01 = new University();
        university01.setId(1000);
        university01.setName("Harvard");

        student01.setUniversity(university01);
        student02.setUniversity(university01);
        student06.setUniversity(university01);

        // introducing configuration file and entity class to hibernate.
        org.hibernate.cfg.Configuration con = new Configuration().configure("hibernate.cfg.xml");
                //.addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);==> i'm not using this
        // because I created 2 lines of code in Hibernate.cdg.xml =>  next 2 lines (manyToOne)
        // <mapping class="hb05.uni_ManyToOne.University"/>
        // <mapping class="hb05.uni_ManyToOne.Student05"/>

        // note that address is not an @Entity class, and you do not need to use this in the configuration
        // the only classes that you need to do the configuration for are the classes we are creating a table from with @Entity.


        // if you don't introduce this resource: into hibernate.cfg.xml then hibernate will not understand hibernate user, password etc.
        // addAnnotatedClass ==> if we do not annotate Student01.class here we will not be able to access this from RunnerFetch01 class.


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);
        session.save(student06);

        session.save(university01);
        session.save(university01);
        session.save(university01);


        tx.commit(); // without commit data will not be sent to DataBase
        session.close();
        sf.close();
    }

}
