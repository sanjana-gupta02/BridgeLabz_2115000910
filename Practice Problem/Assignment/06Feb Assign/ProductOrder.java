import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayProductDetails() {
        System.out.println(name + ": $" + price);
    }
}

class Customers {
    String name;
    List<Order> orders;

    Customers(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orders.add(order);
    }

    void displayCustomerOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

class Order {
    int orderId;
    Customers customer;
    List<Product> products;

    Order(int orderId, Customers customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Products in this Order:");
        for (Product product : products) {
            product.displayProductDetails();
        }
    }
}

public class ProductOrder {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1000.0);
        Product product2 = new Product("Headphones", 150.0);
        Product product3 = new Product("Smartphone", 600.0);

        Customers customer1 = new Customers("SANJANA");

        Order order1 = new Order(1, customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(2, customer1);
        order2.addProduct(product3);

        customer1.placeOrder(order1);
        customer1.placeOrder(order2);

        customer1.displayCustomerOrders();
    }
}
