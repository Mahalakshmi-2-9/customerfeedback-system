package com.customerfeedback;

import java.util.Scanner;
import com.customerfeedbackservice.FeedbackService;

public class MainApp {

    // 🎨 ANSI Color Codes
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String MAGENTA = "\u001B[35m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FeedbackService service = new FeedbackService();
        int choice = 0;

        while (choice != 5) {
            System.out.println(MAGENTA + "\n===== CUSTOMER FEEDBACK SYSTEM =====" + RESET);
            System.out.println(BLUE + "1." + RESET + " Add Customer");
            System.out.println(BLUE + "2." + RESET + " Add Feedback");
            System.out.println(BLUE + "3." + RESET + " Show All Customers");
            System.out.println(BLUE + "4." + RESET + " Show All Feedbacks");
            System.out.println(BLUE + "5." + RESET + " Exit");
            System.out.print(YELLOW + "Enter your choice: " + RESET);

            if (!sc.hasNextInt()) {
                System.out.println(RED + "Invalid input! Please enter a number." + RESET);
                sc.nextLine(); // clear invalid input
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(CYAN + "\n--- Add Customer ---" + RESET);
                    service.addCustomer();
                    break;
                case 2:
                    System.out.println(CYAN + "\n--- Add Feedback ---" + RESET);
                    service.addFeedback();
                    break;
                case 3:
                    System.out.println(GREEN + "\n--- All Customers ---" + RESET);
                    service.showAllCustomers();
                    break;
                case 4:
                    System.out.println(GREEN + "\n--- All Feedbacks ---" + RESET);
                    service.showAllFeedbacks();
                    break;
                case 5:
                    System.out.println(RED + "\nExiting... Thank you!" + RESET);
                    break;
                default:
                    System.out.println(RED + "Invalid choice! Try again." + RESET);
            }
        }

        sc.close();
    }
}
