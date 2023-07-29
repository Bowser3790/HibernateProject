package hb02.embeddable;

import hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//import java.lang.module.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {
        Student02 student01 = new Student02();
        student01.setName("Adam");
        student01.setId(1010);
        student01.setGrade(90);

        Student02 student02 = new Student02();
        student02.setName("Kobe");
        student02.setId(1011);
        student02.setGrade(99);

        Student02 student03 = new Student02();
        student03.setName("Jenny");
        student03.setId(1012);
        student03.setGrade(89);

        Student02 student04 = new Student02();
        student04.setName("William");
        student04.setId(1013);
        student04.setGrade(77);

        Address address01 = new Address();
        address01.setCity("Boston");
        address01.setCountry("USA");
        address01.setStreet("Hobart St");
        address01.setZipCode("01923");

        Address address02 = new Address();
        address02.setCity("Miami");
        address02.setCountry("USA");
        address02.setStreet("Biscayne Blvd");
        address02.setZipCode("33145");

        Address address03 = new Address();
        address03.setCity("Denver");
        address03.setCountry("USA");
        address03.setStreet("Treetop Lane");
        address03.setZipCode("45321");

        Address address04 = new Address();
        address04.setCity("Dover");
        address04.setCountry("USA");
        address04.setStreet("Snowcap Lane");
        address04.setZipCode("65432");

        student01.setAddress(address01);
        student02.setAddress(address02);
        student03.setAddress(address03);
        student04.setAddress(address04);

        // introducing configuration file and entity class to hibernate.
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);
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
        session.save(student04);

        //


        tx.commit(); // without commit data will not be sent to DataBase
        session.close();
        sf.close();







    }


}
