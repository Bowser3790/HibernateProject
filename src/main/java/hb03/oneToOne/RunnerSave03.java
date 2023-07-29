package hb03.oneToOne;

import hb02.embeddable.Student02;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RunnerSave03 {

    public static void main(String[] args) {


        Student03 student01 = new Student03();
        student01.setName("Spam");
        student01.setId(1020);
        student01.setGrade(70);

        Student03 student02 = new Student03();
        student02.setName("Kobe Beef");
        student02.setId(1021);
        student02.setGrade(79);

        Student03 student03 = new Student03();
        student03.setName("yasmin");
        student03.setId(1022);
        student03.setGrade(49);

        Diary diary01 = new Diary();
        diary01.setId(2001);
        diary01.setName("Spam's Diary");

        Diary diary02 = new Diary();
        diary02.setId(2002);
        diary02.setName("Kobe Beef's Diary");

        Diary diary03 = new Diary();
        diary03.setId(2003);
        diary03.setName("Yasmin's Diary");

        diary01.setStudent03(student01);
        diary02.setStudent03(student02);
        diary03.setStudent03(student03);

        // introducing configuration file and entity class to hibernate.
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        // note that address is not an @Entity class, and you do not need to use this in the configuration
        // the only classes that you need to do the configuration for are the classes we are creating a table from with @Entity.


        // if you don't introduce this resource: into hibernate.cfg.xml then hibernate will not understand hibernate user, password etc.
        // addAnnotatedClass ==> if we do not annotate Student01.class here we will not be able to access this from RunnerFetch01 class.


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student01);
        session.save(student02);// did not create student 2 or 3 yet but this is what you would have to do if you did.
        session.save(student03);

        session.save(diary01);
        session.save(diary02);
        session.save(diary03);


        tx.commit(); // without commit data will not be sent to DataBase
        session.close();
        sf.close();
    }


}
