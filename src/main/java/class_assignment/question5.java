package class_assignment;

public class question5 {



        /**
         * Splits a review into words and categorizes them by length into Short, Medium, or Long.
         *
         * @param review The movie review text string
         */
        public static void classifyWordLengths(String review) {
            if (review == null || review.trim().isEmpty()) {
                System.out.println("Short: 0 | Medium: 0 | Long: 0");
                return;
            }

            // Split the string by one or more whitespace characters
            String[] words = review.trim().split("\\s+");

            int shortCount = 0;   // 1 - 4 letters
            int mediumCount = 0;  // 5 - 8 letters
            int longCount = 0;    // 9+ letters

            for (String word : words) {
                int length = word.length();

                if (length >= 1 && length <= 4) {
                    shortCount++;
                } else if (length >= 5 && length <= 8) {
                    mediumCount++;
                } else if (length >= 9) {
                    longCount++;
                }
            }

            // Print final output format
            System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
        }

        public static void main(String[] args) {
            // Sample Test Case
            String sampleInput = "This movie was absolutely fantastic and thrilling";

            System.out.println("Input: \"" + sampleInput + "\"");
            System.out.print("Output: ");
            classifyWordLengths(sampleInput);
        }
    }

