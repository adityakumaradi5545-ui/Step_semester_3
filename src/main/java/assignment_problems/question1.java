package assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question1 {

    static abstract class Customer {
        private final String type;
        protected final double amount;

        Customer(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        String getType() {
            return type;
        }

        abstract double calculateFinalAmount();
    }

    static class Student extends Customer {
        Student(double amount) {
            super("STUDENT", amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount - amount * 0.10;
        }
    }

    static class Staff extends Customer {
        Staff(double amount) {
            super("STAFF", amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount - amount * 0.05;
        }
    }

    static class Guest extends Customer {
        Guest(double amount) {
            super("GUEST", amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount + 10;
        }
    }

    // The only place the type string is looked at: building the right object
    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new Student(amount);
            case "STAFF":
                return new Staff(amount);
            case "GUEST":
                return new Guest(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            bills.add(createCustomer(type, amount));
        }

        double grandTotal = 0;
        for (Customer c : bills) {
            double finalAmount = c.calculateFinalAmount();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", c.getType(), finalAmount));
            grandTotal += finalAmount;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", grandTotal));
    }
}
