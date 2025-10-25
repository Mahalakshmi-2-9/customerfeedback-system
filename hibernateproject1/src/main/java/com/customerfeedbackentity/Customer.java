package com.customerfeedbackentity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks;

    public Customer() {}

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Feedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
