package class_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class question2 {

    // The problem fixes "today" for simplicity
    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    static abstract class LibraryItem {
        private final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        String getTitle() {
            return title;
        }

        abstract int borrowingDays();

        LocalDate calculateDueDate(LocalDate today) {
            return today.plusDays(borrowingDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        @Override
        int borrowingDays() {
            return 14;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }

        @Override
        int borrowingDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        @Override
        int borrowingDays() {
            return 3;
        }
    }

    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(nextLine(br).trim());

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = nextLine(br).trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);   // remove the quotes
            }
            items.add(createItem(type, title));
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(CURRENT_DATE));   // polymorphic
        }
    }
}