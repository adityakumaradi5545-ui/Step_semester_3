package class_problems;
import java.util.Scanner;
public class question_1 {


        public static int[] twoSum(int[] nums, int target) {

            for (int i = 0; i < nums.length; i++) {

                for (int j = i + 1; j < nums.length; j++) {

                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }

            return new int[]{};
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter size: ");
            int n = sc.nextInt();

            int[] nums = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.print("Enter target: ");
            int target = sc.nextInt();

            int[] result = twoSum(nums, target);

            System.out.println("Output: [" + result[0] + ", " + result[1] + "]");

            sc.close();
        }
    }

