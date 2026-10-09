package assignment_problem;

public class question5 {
}
class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

class M5_CompanyEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee("Divya", 65000);
        Employee e2 = new Employee("Arjun", 30000);
        Employee e3 = new Employee("Meera", 48000);

        Employee.printCompanyInfo();
    }
}