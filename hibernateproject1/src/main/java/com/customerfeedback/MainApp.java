package com.customerfeedback;

import com.customerfeedbackdao.FeedbackDAO;
import com.customerfeedbackentity.Customer;
import com.customerfeedbackentity.Feedback;

public class MainApp {
    public static void main(String[] args) {

        FeedbackDAO dao = new FeedbackDAO();

        // Create a customer
        Customer customer = new Customer("Mahalakshmi", "maha@example.com");

        // Create feedback
        Feedback feedback1 = new Feedback("Excellent service!", 5, customer);
        Feedback feedback2 = new Feedback("Good experience.", 4, customer);

        // Link feedback to customer
        customer.setFeedbacks(java.util.List.of(feedback1, feedback2));

        // Save customer (cascades feedback)
        dao.saveCustomer(customer);

        // Fetch all customers
        System.out.println("All Customers:");
        dao.getAllCustomers().forEach(System.out::println);

        // Fetch all feedbacks
        System.out.println("All Feedbacks:");
        dao.getAllFeedbacks().forEach(System.out::println);

        // Shutdown Hibernate
        com.customerfeedbackutil.HibernateUtil.shutdown();
    }
}
