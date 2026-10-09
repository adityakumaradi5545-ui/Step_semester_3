package assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question2 {

    static abstract class Vehicle {
        private final String type;
        protected final int hours;

        Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        String getType() {
            return type;
        }

        abstract double calculateCharge();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super("BIKE", hours);
        }

        @Override
        double calculateCharge() {
            return 10.0 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super("CAR", hours);
        }

        @Override
        double calculateCharge() {
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super("TRUCK", hours);
        }

        @Override
        double calculateCharge() {
            return Math.max(50.0 * hours, 100.0);
        }
    }

    static Vehicle createVehicle(String type, int hours) {
        switch (type) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicles.add(createVehicle(type, hours));
        }

        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", v.getType(), charge));
            grandTotal += charge;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", grandTotal));
    }
}