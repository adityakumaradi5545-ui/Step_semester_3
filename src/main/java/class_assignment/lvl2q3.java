package class_assignment;

public class lvl2q3 {


        static void printSkippingMultiplesOfThree() {

            for (int i = 1; i <= 20; i++) {

                // Check if the number is a multiple of 3
                if (i % 3 == 0) {
                    continue;
                }

                System.out.print(i + " ");
            }
        }

        public static void main(String[] args) {

            printSkippingMultiplesOfThree();
        }
    }

