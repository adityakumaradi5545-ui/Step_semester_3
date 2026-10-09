package class_problems;

public class question5 {
}
class AttendanceSheet {
    private final String[] present;   // private, never returned
    private int count = 0;

    public AttendanceSheet(int maxClassSize) {
        this.present = new String[maxClassSize];
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;                   // already marked, no duplicates
        }
        if (count >= present.length) {
            System.out.println("Cannot mark " + name + ": class is full");
            return;
        }
        present[count] = name;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (present[i].equals(name)) {
                return true;
            }
        }
        return false;
    }
}

 class P5_AttendanceSheet {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}
