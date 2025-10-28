package com.customerfeedbackservice;

import java.util.List;
import java.util.Scanner;
import com.customerfeedbackdao.FeedbackDAO;
import com.customerfeedbackentity.Customer;
import com.customerfeedbackentity.Feedback;

public class FeedbackService {

    FeedbackDAO dao = new FeedbackDAO();
    Scanner sc = new Scanner(System.in);

    public void addCustomer() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(name, email);
        dao.saveCustomer(customer);
        System.out.println("✅ Customer added successfully.");
    }

    public void addFeedback() {
        System.out.print("Enter Feedback Comment: ");
        String comment = sc.nextLine();
        System.out.print("Enter Rating (1-5): ");
        int rating = sc.nextInt();
        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();
        sc.nextLine();

        dao.saveFeedbackWithCustomerId(comment, rating, customerId);
    }

    public void showAllCustomers() {
        List<Customer> customers = dao.getAllCustomers();
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    public void showAllFeedbacks() {
        List<Feedback> feedbacks = dao.getAllFeedbacks();
        for (Feedback f : feedbacks) {
            System.out.println(f);
        }
    }

    public void updateNullComments() {
        dao.updateNullComments();
    }
}
