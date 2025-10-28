package com.customerfeedbackentity;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Feedback() {}

    public Feedback(String comment, int rating, Customer customer) {
        this.comment = comment;
        this.rating = rating;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Feedback [ID=" + id + ", Comment=" + comment + ", Rating=" + rating +
                ", Customer=" + (customer != null ? customer.getName() : "None") + "]";
    }
}
