package vn.edu.vnua.fita.credit;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {
    @SuppressWarnings("unchecked")
    public static List<Student> getAllStudent() {
        Transaction transaction = null;
        List<Student> listOfStudent = null;
        try (Session session = CreditHibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            listOfStudent = session.createQuery("from Student").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }

        return listOfStudent;
    }

    public static Student getStudent(int id) {
        Transaction transaction = null;
        Student student = null;
        try (Session session = CreditHibernateUtil.getSessionFactory().openSession();) {
            transaction = session.beginTransaction();
            student = session.get(Student.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }
        return student;
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDAO.getAllStudent();
        studentList.forEach(std -> System.out.println(std));
    }
}
