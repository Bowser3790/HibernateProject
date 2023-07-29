package hb03.oneToOne;

import hb01.annotation.Student01;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).
                addAnnotatedClass(Diary.class);

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

        Student03 student03 = session.get(Student03.class, 1021);
        System.out.println(student03);

        Diary diary01 = session.get(Diary.class, 2001);
        System.out.println(diary01);

//        System.out.println("=============get diary object over student===========");
//        System.out.println(student03.getDiary());  // this is giving me an compile time error because I did not do mappingBy in the student class.

        System.out.println("==============get student object over Diary========="); // this should be ok because I attached private Student student to the diary object.
        System.out.println(diary01.getStudent03());

        System.out.println("==============get student name over Diary============");
        System.out.println(diary01.getStudent03().getName());

        // inner join is going to get the information that is the same from both tables
        // Left Join is going to get the information from left table and inner table.
        // Right Join is going to get the information from the Right table and the Left table NOT the inner table.
        // Full Join is going to get all the information from all the tables.

//        System.out.println("===============Inner Join==============");
//
//        String Hql1 = "SELECT s.name, d.name FROM Student03 s INNER JOIN FETCH Diary03 d ON s.id = s.student_id";
//
//        List<Object[]> resultList1 = session.createQuery(Hql1).getResultList();
//
//        resultList1.forEach(obj -> System.out.println(Arrays.toString(obj)));

//        System.out.println("=============LEFT JOIN=============");
//        // HQL Version
//        //String Hql2 = "SELECT s.name, d.name FROM t_student03 s LEFT JOIN FETCH t_diary d ON s.id = s.student_id";
//
//        // HQL Version
//        String Hql2 = "SELECT s.name, d.name FROM Student03 s LEFT JOIN FETCH Diary03 d ON s.id = s.student_id";
//
//        List<Object[]> resultList2 = session.createQuery(Hql2).getResultList();
//
//        resultList2.forEach(obj -> System.out.println(Arrays.toString(obj)));

//        String Hql3 = "SELECT s.name, d.name FROM Student03 s RIGHT JOIN FETCH Diary03 d ON s.id = s.student_id";
//
//        List<Object[]> resultList3 = session.createQuery(Hql3).getResultList();
//
//        resultList3.forEach(obj -> System.out.println(Arrays.toString(obj)));

        String Hql4 = "SELECT s.name, d.name FROM Student03 s FULL JOIN FETCH Diary03 d ON s.id = s.student_id";

        List<Object[]> resultList4 = session.createQuery(Hql4).getResultList();

        resultList4.forEach(obj -> System.out.println(Arrays.toString(obj)));


        tx.commit();
        session.close();
        sf.close();

    }



}
