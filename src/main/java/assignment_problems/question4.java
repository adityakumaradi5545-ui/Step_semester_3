package assignment_problems;

public class question4 {
}
class TrafficLight {
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

    private final String id;       // fixed at creation
    private int position = 0;      // index into CYCLE; starts on RED

    public TrafficLight(String id) {
        this.id = id;
    }

    // The only way to change the color: move forward one step in the cycle
    public String next() {
        position = (position + 1) % CYCLE.length;
        return CYCLE[position];
    }

    public String getColor() {
        return CYCLE[position];
    }

    public String getId() {
        return id;
    }
}

 class A4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("getColor() -> " + t.getColor());
        System.out.println("next() -> " + t.next());
        System.out.println("next() -> " + t.next());
        System.out.println("next() -> " + t.next());
        System.out.println("next() -> " + t.next());
    }
}