package class_assignment;

public class question2 {


        /**
         * Compares two strings character by character and displays match count,
         * accuracy percentage, and the position of the first mismatch (1-based index).
         *
         * @param original The original passage string
         * @param typed    The user's typed string
         */
        public static void checkTypingAccuracy(String original, String typed) {
            if (original == null || typed == null || original.length() != typed.length()) {
                System.out.println("Invalid input: Strings must be non-null and of equal length.");
                return;
            }

            int totalLength = original.length();
            int matchedCount = 0;
            int firstMismatchPosition = -1;
            char origChar = ' ';
            char typedChar = ' ';

            // Traverse both strings character by character
            for (int i = 0; i < totalLength; i++) {
                char c1 = original.charAt(i);
                char c2 = typed.charAt(i);

                if (c1 == c2) {
                    matchedCount++;
                } else {
                    // Record the first mismatch position (1-based index)
                    if (firstMismatchPosition == -1) {
                        firstMismatchPosition = i + 1;
                        origChar = c1;
                        typedChar = c2;
                    }
                }
            }

            // Calculate accuracy percentage
            double accuracy = ((double) matchedCount / totalLength) * 100;

            // Build output string based on mismatch presence
            if (firstMismatchPosition != -1) {
                System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                        matchedCount, totalLength, accuracy, firstMismatchPosition, origChar, typedChar);
            } else {
                System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                        matchedCount, totalLength, accuracy);
            }
        }

        public static void main(String[] args) {
            // Test Case 1: Mismatch present
            String original1 = "hello world";
            String typed1 = "hello worlt";
            checkTypingAccuracy(original1, typed1);

            // Test Case 2: No mismatch present
            String original2 = "coding";
            String typed2 = "coding";
            checkTypingAccuracy(original2, typed2);
        }
    }

