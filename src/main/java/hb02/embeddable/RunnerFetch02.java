package hb02.embeddable;

import hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch02 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // In order to fetch data from DataBase there are 3 ways:
        // 1. get(); 2. SQL query 3. HQL query

        // if you use the get method() and it takes 2 parameters 1. class and 2. ID.

        Student02 student02 = session.get(Student02.class, 1010);
        System.out.println(student02); // print out all lines from student02
        System.out.println("-----------------------------");
        System.out.println(student02.getAddress()); // to only print address of student02 query





        tx.commit();
        session.close();
        sf.close();
    }



}
