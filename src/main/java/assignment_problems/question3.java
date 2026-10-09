package assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question3 {

    static abstract class Room {
        private final String type;
        protected final int units;

        Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        String getType() {
            return type;
        }

        abstract double calculateBill();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) {
            super("SINGLE", units);
        }

        @Override
        double calculateBill() {
            return 8.0 * units;
        }
    }

    static class SharedRoom extends Room {
        private final int occupants;   // extra value lives in the subclass

        SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        @Override
        double calculateBill() {
            return (6.0 * units) / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(int units) {
            super("AC", units);
        }

        @Override
        double calculateBill() {
            return 10.0 * units + 200.0;
        }
    }

    // Reads the rest of one line, including the extra occupants value for SHARED
    static Room createRoom(String type, Scanner sc) {
        int units = sc.nextInt();
        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, sc.nextInt());
            case "AC":
                return new AcRoom(units);
            default:
                throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            rooms.add(createRoom(type, sc));
        }

        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", r.getType(), bill));
            grandTotal += bill;
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", grandTotal));
    }
}