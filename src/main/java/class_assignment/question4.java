package class_assignment;

public class question4 {


        /**
         * Calculates totals for Section A and Section B, checks if they are balanced,
         * and finds the single highest quantity item along with its section and 1-based index.
         *
         * @param sectionA Quantities in Section A
         * @param sectionB Quantities in Section B
         */
        public static void analyzeInventory(int[] sectionA, int[] sectionB) {
            if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
                System.out.println("Invalid input: Arrays must be non-null and of equal length.");
                return;
            }

            int totalA = 0;
            int totalB = 0;

            int maxQuantity = Integer.MIN_VALUE;
            String maxSection = "";
            int maxIndex = -1; // 1-based item index

            // Scan Section A: accumulate total and track maximum
            for (int i = 0; i < sectionA.length; i++) {
                totalA += sectionA[i];
                if (sectionA[i] > maxQuantity) {
                    maxQuantity = sectionA[i];
                    maxSection = "Section A";
                    maxIndex = i + 1; // 1-based index as shown in sample output ("Item 3")
                }
            }

            // Scan Section B: accumulate total and track maximum
            for (int i = 0; i < sectionB.length; i++) {
                totalB += sectionB[i];
                if (sectionB[i] > maxQuantity) {
                    maxQuantity = sectionB[i];
                    maxSection = "Section B";
                    maxIndex = i + 1;
                }
            }

            // Determine balance status
            String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

            // Print final result matching the exact expected format
            System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                    totalA, totalB, status, maxQuantity, maxSection, maxIndex);
        }

        public static void main(String[] args) {
            // Sample Test Case
            int[] sectionA = {20, 15, 30};
            int[] sectionB = {25, 10, 30};

            analyzeInventory(sectionA, sectionB);
        }
    }


