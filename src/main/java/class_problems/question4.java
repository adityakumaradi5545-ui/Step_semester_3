package class_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class question4 {

    static abstract class Question {
        private final String type;
        protected final String text;
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final double points;

        Question(String type, String text, String correctAnswer, String studentAnswer, double points) {
            this.type = type;
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        String getType() {
            return type;
        }

        abstract double evaluate();
    }

    static class McqQuestion extends Question {
        McqQuestion(String text, String correct, String student, double points) {
            super("MCQ", text, correct, student, points);
        }

        @Override
        double evaluate() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String text, String correct, String student, double points) {
            super("TF", text, correct, student, points);
        }

        @Override
        double evaluate() {
            return studentAnswer.equals(correctAnswer) ? points : 0;
        }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String text, String correct, String student, double points) {
            super("ESSAY", text, correct, student, points);
        }

        @Override
        double evaluate() {
            String answer = studentAnswer.toLowerCase();
            int matched = 0;
            for (String keyword : correctAnswer.split(",")) {
                String k = keyword.trim().toLowerCase();
                if (!k.isEmpty() && answer.contains(k)) {
                    matched++;
                }
            }
            if (matched >= 2) {
                return points * 0.75;
            } else if (matched == 1) {
                return points * 0.50;
            }
            return 0;
        }
    }

    static Question createQuestion(String type, String text, String correct, String student, double points) {
        switch (type) {
            case "MCQ":
                return new McqQuestion(text, correct, student, points);
            case "TF":
                return new TrueFalseQuestion(text, correct, student, points);
            case "ESSAY":
                return new EssayQuestion(text, correct, student, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    // Reads the next non-empty line
    static String nextLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        return line;
    }

    // Parses: TYPE "text" "correct" "student" points
    static Question parseQuestion(String line) {
        line = line.trim();
        int space = line.indexOf(' ');
        String type = line.substring(0, space);
        String rest = line.substring(space).trim();

        String[] quoted = new String[3];
        int pos = 0;
        for (int k = 0; k < 3; k++) {
            int start = rest.indexOf('"', pos);
            int end = rest.indexOf('"', start + 1);
            quoted[k] = rest.substring(start + 1, end);
            pos = end + 1;
        }
        double points = Double.parseDouble(rest.substring(pos).trim());
        return createQuestion(type, quoted[0], quoted[1], quoted[2], points);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(nextLine(br).trim());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(parseQuestion(nextLine(br)));
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.evaluate();   // polymorphic call
            System.out.println(String.format(Locale.US, "%s: %.2f", q.getType(), score));
            total += score;
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
    }
}