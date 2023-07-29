package hb01.annotation;

// this class is used to read data

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // In order to fetch data from DataBase there are 3 ways:
        // 1. get(); 2. SQL query 3. HQL query

        //==========Way #1================

        //Student01 student1 = session.get(Student01.class, 1001);
        //System.out.println(student1);
//        Student01 student2 = session.get(Student01.class, 1002);
//        System.out.println(student1);
//        Student01 student3 = session.get(Student01.class, 1003);
//        System.out.println(student1);
//        Note that both of these will be getting the data from the DB if I created student2 and student3
        // get method will run a SELECT query

        //=============Way #2===============

//        String sqlQuery = "SELECT * FROM t_student01";
//        List<Object[]> resultList = session.createSQLQuery(sqlQuery).getResultList(); // -> what does this-> session.createSQLQuery(sqlquery), return? Object [array]
//        // this is why we have Object[] as a data type.
//        // **Important** why did we create a List<Object[]>? Because we are returning more than 1 Object there are 3 objects in this database.
//        for (Object[] std: resultList){
//            System.out.println(Arrays.toString(std));

        //}

        // =========Way #3========
//        String hqlQuery1 = "FROM Student01";
//        List<Student01> resultList2 = session.createQuery(hqlQuery1, Student01.class).getResultList();
//
//        for(Student01 std: resultList2){
//            System.out.println(std);
//        }

        // if you want to fetch some unique data using hql
//        String hqlQuery2 = "SELECT * FROM t_student01 WHERE std_name = 'Cigdem'";
//        Object[] StudentCigdem = (Object[]) session.createSQLQuery(hqlQuery2).uniqueResult(); // uniqueResult() returns an object and we need to cast the (Object[])
//        System.out.println(Arrays.toString(StudentCigdem));
//        // or you can use this below
//        System.out.println(StudentCigdem[0] + " " + StudentCigdem[1] + " " + StudentCigdem[2]);


        // if you want to fetch some unique data using hql

//        String hqlQuery2 = "FROM Student01 s WHERE s.name = 'Fogart'";
//        Student01 std = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
//        System.out.println(std);

        // if you want to fetch students whose id is less than 1003 using hql
        String hqlQuery3 = "SELECT s.name, s.id FROM Student01 s WHERE s.id<1003";
        List<Object[]> resultList = session.createQuery(hqlQuery3).getResultList();
        resultList.forEach(x-> System.out.println(Arrays.toString(x)));




        tx.commit();
        session.close();
        sf.close();

    }
}
