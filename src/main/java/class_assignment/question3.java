package class_assignment;

public class question3 {


        /**
         * Scans a string of signal readings to find and display the longest streak
         * of consecutive identical characters.
         *
         * @param signalLog String of signal characters (e.g., "RRGGGYRR")
         */
        public static void findLongestStreak(String signalLog) {
            if (signalLog == null || signalLog.isEmpty()) {
                System.out.println("Invalid input: Signal log is empty.");
                return;
            }

            char longestColor = signalLog.charAt(0);
            int maxStreak = 1;

            char currentColor = signalLog.charAt(0);
            int currentStreak = 1;

            // Iterate starting from the second character
            for (int i = 1; i < signalLog.length(); i++) {
                char ch = signalLog.charAt(i);

                if (ch == currentColor) {
                    currentStreak++;
                } else {
                    // Check if current streak exceeds the maximum streak recorded so far
                    if (currentStreak > maxStreak) {
                        maxStreak = currentStreak;
                        longestColor = currentColor;
                    }
                    // Reset tracker for the new character sequence
                    currentColor = ch;
                    currentStreak = 1;
                }
            }

            // Final check for the last streak in the string
            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                longestColor = currentColor;
            }

            System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreak + " times");
        }

        public static void main(String[] args) {
            // Sample Test Case 1
            String test1 = "RRGGGYRR";
            System.out.print("Input: \"" + test1 + "\"\nOutput: ");
            findLongestStreak(test1);

            System.out.println();

            // Sample Test Case 2
            String test2 = "RRRRYGG";
            System.out.print("Input: \"" + test2 + "\"\nOutput: ");
            findLongestStreak(test2);
        }
    }

