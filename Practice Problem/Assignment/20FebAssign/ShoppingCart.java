import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    public void displayCartInOrder() {
        System.out.println("Shopping Cart (Added Order):");
        cart.forEach((product, quantity) ->
                System.out.println(product + " - Quantity: " + quantity + ", Price: " + productPrices.get(product))
        );
    }

    public void displayCartSortedByPrice() {
        TreeMap<Double, String> sortedByPrice = new TreeMap<>();
        for (String product : cart.keySet()) {
            sortedByPrice.put(productPrices.get(product), product);
        }

        System.out.println("Shopping Cart (Sorted by Price):");
        sortedByPrice.forEach((price, product) ->
                System.out.println(product + " - Price: " + price + ", Quantity: " + cart.get(product))
        );
    }

    public double calculateTotal() {
        double total = 0;
        for (String product : cart.keySet()) {
            total += productPrices.get(product) * cart.get(product);
        }
        return total;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 800.00);
        cart.addProduct("Phone", 500.00);
        cart.addProduct("Tablet", 300.00);
        cart.addProduct("Headphones", 100.00);

        cart.addToCart("Laptop", 1);
        cart.addToCart("Phone", 2);
        cart.addToCart("Headphones", 3);

        cart.displayCartInOrder();
        System.out.println();
        cart.displayCartSortedByPrice();
        System.out.println("\nTotal Price: $" + cart.calculateTotal());
    }
}
