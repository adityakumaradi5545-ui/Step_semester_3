package assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class question4 {

    static abstract class Employee {
        private final String name;
        protected final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        String getName() {
            return name;
        }

        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return monthlySalary * 0.05;
        }
    }

    static class Intern extends Employee {
        Intern(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        double calculateBonus() {
            return 2000.0;   // fixed, whatever the salary
        }
    }

    static Employee createEmployee(String type, String name, double monthlySalary) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee(name, monthlySalary);
            case "PARTTIME":
                return new PartTimeEmployee(name, monthlySalary);
            case "INTERN":
                return new Intern(name, monthlySalary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            employees.add(createEmployee(type, name, salary));
        }

        double grandTotal = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", e.getName(), bonus));
            grandTotal += bonus;
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", grandTotal));
    }
}