package class_problems;

public class question2 {
}
class Scorecard {
    private final boolean[] results;   // private, never returned in any form
    private final int totalQuestions;  // fixed at creation
    private int recorded = 0;          // how many answers recorded so far

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean correct) {
        if (recorded >= totalQuestions) {
            System.out.println("Answer rejected: all " + totalQuestions + " questions already recorded");
            return;
        }
        results[recorded] = correct;
        recorded++;
    }

    // Only a number computed from the array leaves the class
    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}

 class P2_Scorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("getScore() -> " + sc.getScore());

        sc.recordAnswer(true);  // extra answer: rejected
        System.out.println("getScore() after extra answer -> " + sc.getScore());
    }
}