package class_problems;
import java.util.Scanner;
public class question_2 {




        public static int maxProfit(int[] prices) {

            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {

                int profit = prices[i] - minPrice;

                if (profit > maxProfit) {
                    maxProfit = profit;
                }

                if (prices[i] < minPrice) {
                    minPrice = prices[i];
                }
            }

            return maxProfit;
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter size: ");
            int n = sc.nextInt();

            int[] prices = new int[n];

            System.out.println("Enter prices:");
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }

            int result = maxProfit(prices);

            System.out.println("Maximum Profit = " + result);

            sc.close();
        }
    }

