package assignment_problems;

public class question1 {
}
class Character {
    private final int maxHealth;   // fixed at creation
    private int health;            // private, no setter

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Damage rejected: amount cannot be negative");
            return;
        }
        int newHealth = health - amount;        // calculate first...
        health = Math.max(newHealth, 0);        // ...then clamp at 0
    }

    public void heal(int amount) {
        if (amount < 0) {
            System.out.println("Heal rejected: amount cannot be negative");
            return;
        }
        int newHealth = health + amount;        // calculate first...
        health = Math.min(newHealth, maxHealth); // ...then clamp at max
    }

    public int getHealth() {
        return health;
    }
}

 class A1_Character {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("heal(50) -> health = " + c.getHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("takeDamage(150) -> health = " + c.getHealth() + " (floored)");
    }
}