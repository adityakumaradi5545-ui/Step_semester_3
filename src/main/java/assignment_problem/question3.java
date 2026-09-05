package assignment_problem;

public class question3 {


        static String findMinMaxSpread(int[] scores) {

            int min = scores[0];
            int max = scores[0];

            for (int x : scores) {
                if (x < min)
                    min = x;

                if (x > max)
                    max = x;
            }

            return "Min: " + min +
                    " | Max: " + max +
                    " | Spread: " + (max - min);
        }

        public static void main(String[] args) {

            int[] scores = {45, 82, 79, 90, 33, 90, 61};

            System.out.println(findMinMaxSpread(scores));
        }
    }

