package class_problem;
import java.util.*;
public class question1 {




        // Method to determine the result of one round
        static String playRound(String playerMove, String computerMove) {

            if (playerMove.equals(computerMove)) {
                return "Draw";
            }

            if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
                return "Player Wins";
            }

            return "Computer Wins";
        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            String[] moves = {"Rock", "Paper", "Scissors"};

            int rounds = 5;
            int wins = 0, losses = 0, draws = 0;

            String[] playerMoves = new String[rounds];
            String[] computerMoves = new String[rounds];
            String[] results = new String[rounds];

            // Play 5 rounds
            for (int i = 0; i < rounds; i++) {

                System.out.print("Enter your move (Rock/Paper/Scissors): ");
                String playerMove = sc.next();

                // Generate computer move randomly
                String computerMove = moves[random.nextInt(3)];

                // Find result
                String result = playRound(playerMove, computerMove);

                playerMoves[i] = playerMove;
                computerMoves[i] = computerMove;
                results[i] = result;

                // Count results
                if (result.equals("Player Wins")) {
                    wins++;
                } else if (result.equals("Computer Wins")) {
                    losses++;
                } else {
                    draws++;
                }
            }

            // Display summary table
            System.out.println("\n--------------- FINAL SUMMARY ---------------");
            System.out.printf("%-8s %-15s %-15s %-15s%n",
                    "Round", "Player Move", "Computer Move", "Result");

            for (int i = 0; i < rounds; i++) {
                System.out.printf("%-8d %-15s %-15s %-15s%n",
                        i + 1, playerMoves[i], computerMoves[i], results[i]);
            }

            // Calculate win percentage
            double winPercentage = (wins * 100.0) / rounds;

            System.out.println("----------------------------------------------");
            System.out.println("Wins   : " + wins);
            System.out.println("Losses : " + losses);
            System.out.println("Draws  : " + draws);
            System.out.printf("Win %%  : %.1f%%%n", winPercentage);

            sc.close();
        }
    }

