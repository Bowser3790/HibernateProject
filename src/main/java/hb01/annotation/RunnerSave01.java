package hb01.annotation;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    // this class is used to store objects to database
    public static void main(String[] args) {

        Student01 student1 = new Student01();
        student1.setId(1001);
        student1.setName("Cigdem");
        student1.setGrade(99);

        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Wilton");
        student2.setGrade(95);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Fogart");
        student3.setGrade(91);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);
        // if you don't introduce this resource: into hibernate.cfg.xml then hibernate will not understand hibernate user, password etc.
        // addAnnotatedClass ==> if we do not annotate Student01.class here we will not be able to access this from RunnerFetch01 class.
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);// did not create student 2 or 3 yet but this is what you would have to do if you did.
        session.save(student3);


        tx.commit(); // without commit data will not be sent to DataBase
        session.close();
        sf.close();



    }


}
