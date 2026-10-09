package class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question5 {

    static abstract class Journey {
        private final String type;
        protected final double distance;

        Journey(String type, double distance) {
            this.type = type;
            this.distance = distance;
        }

        String getType() {
            return type;
        }

        abstract double calculateFare();
    }

    static class BusJourney extends Journey {
        BusJourney(double distance) {
            super("BUS", distance);
        }

        @Override
        double calculateFare() {
            return Math.min(2.0 + 0.10 * distance, 10.0);   // capped at $10
        }
    }

    static class TrainJourney extends Journey {
        TrainJourney(double distance) {
            super("TRAIN", distance);
        }

        @Override
        double calculateFare() {
            return 3.0 + 0.15 * distance;
        }
    }

    static class MetroJourney extends Journey {
        private final double peakHourFactor;   // extra value lives in the subclass

        MetroJourney(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        @Override
        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    // Reads the rest of one line, including PeakHourFactor for METRO
    static Journey createJourney(String type, Scanner sc) {
        double distance = sc.nextDouble();
        switch (type) {
            case "BUS":
                return new BusJourney(distance);
            case "TRAIN":
                return new TrainJourney(distance);
            case "METRO":
                return new MetroJourney(distance, sc.nextDouble());
            default:
                throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            journeys.add(createJourney(type, sc));
        }

        double grandTotal = 0;
        for (Journey j : journeys) {
            double fare = j.calculateFare();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", j.getType(), fare));
            grandTotal += fare;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", grandTotal));
    }
}
