package class_problems;

public class question4 {
}
class Locker {
    private final int lockerNumber;   // fixed at creation
    private String code;              // private, deliberately no getter

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public boolean changeCode(String currentCode, String newCode) {
        // Check the old code first; if it fails, do nothing else
        if (!code.equals(currentCode)) {
            System.out.println("Locker " + lockerNumber + ": change rejected, wrong current code");
            return false;
        }
        code = newCode;
        System.out.println("Locker " + lockerNumber + ": code changed successfully");
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

 class P4_Locker {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");   // success
        l.changeCode("0000", "9999");   // rejected, code is still "5678"

        // Proof the code is still 5678: the old code "1234" no longer works, "5678" does
        l.changeCode("1234", "1111");   // rejected
        l.changeCode("5678", "5678");   // accepted, confirms code was "5678"
    }
}