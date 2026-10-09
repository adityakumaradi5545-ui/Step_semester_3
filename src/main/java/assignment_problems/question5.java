package assignment_problems;

public class question5 {
}
class Cart {
    private final String cartId;     // fixed at creation
    private final double[] prices;   // private, never returned
    private int count = 0;           // how many items added so far

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
    }

    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Item rejected: price cannot be negative");
            return;
        }
        if (count >= prices.length) {
            System.out.println("Item rejected: cart is full");
            return;
        }
        prices[count] = price;
        count++;
    }

    // Computed on request by looping over the private array
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }
}

 class A5_Cart {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("getTotal() -> " + cart.getTotal());
        System.out.println("getItemCount() -> " + cart.getItemCount());
    }
}