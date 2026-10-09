package assignment_problems;

public class question3 {
}
class PasswordChecker {
    private final String password;   // final: cannot change; no getter exposes it

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

class A3_PasswordChecker {
    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("abcd (4 chars) -> " + pc.getStrength());

        PasswordChecker medium = new PasswordChecker("abcdefgh");
        System.out.println("abcdefgh (8 chars) -> " + medium.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println("abcdefghij (10 chars) -> " + pc2.getStrength());

        PasswordChecker twelve = new PasswordChecker("abcdefghijkl");
        System.out.println("abcdefghijkl (12 chars) -> " + twelve.getStrength());
    }
}
