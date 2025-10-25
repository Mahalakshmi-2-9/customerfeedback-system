package com.customerfeedbackdao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.customerfeedbackentity.Customer;
import com.customerfeedbackentity.Feedback;
import com.customerfeedbackutil.HibernateUtil;
import java.util.List;

public class FeedbackDAO {

    public void saveCustomer(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void saveFeedback(Feedback feedback) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(feedback);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Customer", Customer.class).list();
        }
    }

    public List<Feedback> getAllFeedbacks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Feedback", Feedback.class).list();
        }
    }
}
