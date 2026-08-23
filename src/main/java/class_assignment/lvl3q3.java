package class_assignment;
import java.util.Scanner;
public class lvl3q3 {




        static void simulateTrafficSignal(int cycles) {

            int state = 0; // 0 = Red, 1 = Green, 2 = Yellow

            for (int i = 0; i < cycles; i++) {

                switch (state) {

                    case 0:
                        System.out.print("Red - Stop ");
                        break;

                    case 1:
                        System.out.print("Green - Go ");
                        break;

                    case 2:
                        System.out.print("Yellow - Prepare to stop ");
                        break;
                }

                // Move to the next state
                state = (state + 1) % 3;
            }
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of cycles: ");
            int cycles = sc.nextInt();

            simulateTrafficSignal(cycles);

            sc.close();
        }
    }


