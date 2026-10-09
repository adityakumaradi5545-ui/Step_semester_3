package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question3 {

    static abstract class Delivery {
        private final String type;
        protected final double weight;
        protected final double distance;

        Delivery(String type, double weight, double distance) {
            this.type = type;
            this.weight = weight;
            this.distance = distance;
        }

        String getType() {
            return type;
        }

        abstract double calculateFee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        @Override
        double calculateFee() {
            return 5.0 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        @Override
        double calculateFee() {
            return 15.0 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;   // extra value lives in the subclass

        InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        @Override
        double calculateFee() {
            return 25.0 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    // Reads the rest of one line, including CustomsFee for INTERNATIONAL
    static Delivery createDelivery(String type, Scanner sc) {
        double weight = sc.nextDouble();
        double distance = sc.nextDouble();
        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            case "INTERNATIONAL":
                return new InternationalDelivery(weight, distance, sc.nextDouble());
            default:
                throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            deliveries.add(createDelivery(type, sc));
        }

        double grandTotal = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", d.getType(), fee));
            grandTotal += fee;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", grandTotal));
    }
}