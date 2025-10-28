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
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void saveFeedbackWithCustomerId(String comment, int rating, int customerId) {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);

            if (customer != null) {
                Feedback feedback = new Feedback(comment, rating, customer);
                session.save(feedback);
                System.out.println("✅ Feedback added for customer: " + customer.getName());
            } else {
                System.out.println("⚠️ Customer ID not found!");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Customer> getAllCustomers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> list = session.createQuery("from Customer", Customer.class).list();
        session.close();
        return list;
    }

    public List<Feedback> getAllFeedbacks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Feedback> list = session.createQuery("from Feedback", Feedback.class).list();
        session.close();
        return list;
    }

    public void updateNullComments() {
        Transaction tx = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tx = session.beginTransaction();
            String hql = "UPDATE Feedback f SET f.comment = :defaultComment WHERE f.comment IS NULL";
            int updated = session.createMutationQuery(hql)
                                 .setParameter("defaultComment", "No comment provided")
                                 .executeUpdate();
            tx.commit();
            System.out.println(updated + " feedback(s) updated successfully.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
