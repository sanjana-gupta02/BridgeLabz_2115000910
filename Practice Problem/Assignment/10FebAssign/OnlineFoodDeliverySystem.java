import java.util.*;

// Interface defining discount behavior
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private final String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public void applyDiscount(double percentage) {
        setPrice(getPrice() - (getPrice() * percentage / 100));
    }

    @Override
    public String getDiscountDetails() {
        return "Veg item discount applied.";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private static final double EXTRA_CHARGE = 50;

    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    double calculateTotalPrice() {
        return (getPrice() + EXTRA_CHARGE) * getQuantity();
    }

    @Override
    public void applyDiscount(double percentage) {
        setPrice(getPrice() - (getPrice() * percentage / 100));
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg item discount applied.";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        VegItem vegBurger = new VegItem("Veg Burger", 120, 2);
        NonVegItem chickenPizza = new NonVegItem("Pizza", 300, 1);

        order.add(vegBurger);
        order.add(chickenPizza);

        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10);
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("Price after discount: " + item.calculateTotalPrice());
            }
        }
    }
}
