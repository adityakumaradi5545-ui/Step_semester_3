package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question1 {

    static abstract class Payment {
        private final String type;
        protected final double amount;

        Payment(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        String getType() {
            return type;
        }

        abstract double calculateFinalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) {
            super("CARD", amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount + amount * 0.02;   // 2% fee
        }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) {
            super("WALLET", amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount + amount * 0.01;   // 1% fee
        }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        @Override
        double calculateFinalAmount() {
            return amount;                   // no fee
        }
    }

    static Payment createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            payments.add(createPayment(type, amount));
        }

        double grandTotal = 0;
        for (Payment p : payments) {
            double adjusted = p.calculateFinalAmount();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", p.getType(), adjusted));
            grandTotal += adjusted;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", grandTotal));
    }
}