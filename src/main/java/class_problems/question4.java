package class_problems;
import java.util.Scanner;
public class question4 {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter first number: ");
            int number1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int number2 = sc.nextInt();

            while (number2 != 0) {
                int remainder = number1 % number2;
                number1 = number2;
                number2 = remainder;
            }

            System.out.println("The GCD is " + number1);
        }
    }

