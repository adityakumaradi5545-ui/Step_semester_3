package class_assignment;

public class question1 {


        /**
         * Scans seat numbers to detect and report duplicate seat allocations.
         * Uses only basic loops and arrays (no Collections API).
         */
        public static void checkDuplicateSeats(int[] seatNumbers) {
            if (seatNumbers == null || seatNumbers.length == 0) {
                System.out.println("No Duplicate Seats Found");
                return;
            }

            boolean duplicateFound = false;

            for (int i = 0; i < seatNumbers.length; i++) {

                // Check if this seat number was already handled in a previous iteration
                boolean alreadyProcessed = false;
                for (int k = 0; k < i; k++) {
                    if (seatNumbers[i] == seatNumbers[k]) {
                        alreadyProcessed = true;
                        break;
                    }
                }

                if (alreadyProcessed) {
                    continue;
                }

                // Compare seatNumbers[i] with all remaining items in the array
                for (int j = i + 1; j < seatNumbers.length; j++) {
                    if (seatNumbers[i] == seatNumbers[j]) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        duplicateFound = true;
                        break;
                    }
                }
            }

            if (!duplicateFound) {
                System.out.println("No Duplicate Seats Found");
            }
        }

        public static void main(String[] args) {
            // Sample Input 1: Duplicate present
            int[] test1 = {101, 102, 103, 102, 105};
            System.out.print("Input: {101, 102, 103, 102, 105}\nOutput: ");
            checkDuplicateSeats(test1);

            System.out.println();

            // Sample Input 2: No duplicates present
            int[] test2 = {101, 102, 103, 104, 105};
            System.out.print("Input: {101, 102, 103, 104, 105}\nOutput: ");
            checkDuplicateSeats(test2);
        }
    }

