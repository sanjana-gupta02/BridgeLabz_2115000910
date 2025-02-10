import java.util.*;

// Interface defining tax behavior
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product
abstract class Product {
    private final int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Electronics subclass
class Electronics extends Product implements Taxable {
    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.1;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "15% VAT applied";
    }
}

// Clothing subclass
class Clothing extends Product implements Taxable {
    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.2;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "5% Sales Tax applied";
    }
}

// Groceries subclass
class Groceries extends Product {
    Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Electronics prod1 = new Electronics(201, "Laptop", 80000);
        Clothing prod2 = new Clothing(202, "Dress", 1500);
        Groceries prod3 = new Groceries(203, "Choclates", 500);

        products.add(prod1);
        products.add(prod2);
        products.add(prod3);

        for (Product prod : products) {
            prod.displayDetails();
            double finalPrice = prod.getPrice() - prod.calculateDiscount();
            if (prod instanceof Taxable) {
                finalPrice += ((Taxable) prod).calculateTax();
                System.out.println("Tax: " + ((Taxable) prod).getTaxDetails());
            }
            System.out.println("Final Price: " + finalPrice);
        }
    }
}
