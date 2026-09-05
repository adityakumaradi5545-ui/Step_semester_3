import java.util.Arrays;
public class question3 {


        static int[] findTopThreeScores(int[] a) {
            int x = Integer.MIN_VALUE, y = x, z = x;
            for (int n : a) {
                if (n >= x) { z = y; y = x; x = n; }
                else if (n >= y) { z = y; y = n; }
                else if (n > z) z = n;
            }
            return new int[]{x, y, z};
        }
        public static void main(String[] args) {
            int[] a = {45, 82, 79, 90, 33, 90, 61};
            System.out.println(Arrays.toString(findTopThreeScores(a)));
        }
    }


