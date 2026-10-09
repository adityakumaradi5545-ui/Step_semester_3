package assignment_problem;

public class question4 {
}
class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

 class M4_HallTicket {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;          // same object, not a new one
        copy.seatNumber = 45;             // change via second reference

        HallTicket separate = new HallTicket("Priya", 45);  // different object, same values

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}