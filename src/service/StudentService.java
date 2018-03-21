/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import core.SessionFactoryUtil;
import dto.Student;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Sandaru Chamod
 */
public class StudentService {
    
    public static SessionFactory sessionFactory;
    
    public static boolean addNewStudent(Student s1){
        sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        
        try{
            transaction = session.beginTransaction();
            Student student = new Student();
            student.setsName(s1.getsName());
            student.setAddress(s1.getAddress());
            student.setTel(s1.getTel());
            session.save(student);
            
            transaction.commit();
            return true;

        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
   public static boolean updateStudent(Student s1){
        sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        
        try{
            transaction = session.beginTransaction();
            Student student = new Student(); 
            Criteria cr2 = session.createCriteria(Student.class).add(Restrictions.eq("sName", s1.getsName()));
            List<Student> sList=cr2.list();
            for (Student student1 : sList) {
                student1.setsName(s1.getsName());
                student1.setAddress(s1.getAddress());
                student1.setTel(s1.getTel());
                session.update(student1);
            }
            
            transaction.commit();
            return true;

        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
    public static boolean deleteStudent(String s1){
        sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        
        try{
            transaction = session.beginTransaction();
            Student student = new Student();            
            Criteria cr2 = session.createCriteria(Student.class).add(Restrictions.eq("sName", s1));
            List<Student> list=cr2.list();
            for (Student student1 : list) {
                session.delete(student1);
            }
                   
            transaction.commit();
            return true;

        }catch(HibernateException e){
            e.printStackTrace();
            return false;
        }finally{
            session.close();
        }
    }
    public static Student searchStudent(String sName){
        sessionFactory=SessionFactoryUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        
        try{
            transaction = session.beginTransaction();
            Student student = new Student();            
            Criteria cr2 = session.createCriteria(Student.class).add(Restrictions.eq("sName", sName));
            List<Student> list=cr2.list();
            for (Student student1 : list) {
                student.setsName(student1.getsName());
                student.setAddress(student1.getAddress());
                student.setTel(student1.getTel());
            }
                   
            transaction.commit();
            return student;

        }catch(HibernateException e){
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }
    public static List<Student> viewStudent(){
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = null;
        
        try{
            transaction = session.beginTransaction();
            Student student = new Student();            
            List<Student> stList = session.createQuery("from Student").list();
//            for (Student student1 : stList) {
//                student.setsName(student1.getsName());
//                student.setAddress(student1.getAddress());
//                student.setTel(student1.getTel());
//            }
//                   
            transaction.commit();
            return stList;

        }catch(HibernateException e){
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }
}
