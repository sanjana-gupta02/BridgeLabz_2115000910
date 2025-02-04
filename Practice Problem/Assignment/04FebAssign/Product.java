import java.util.Scanner;

class Product {
    static double discount = 10.0;
    final int productID;
    String productName;
    double price;
    int quantity;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    void displayProductDetails() {
        if (this instanceof Product) {
            double discountedPrice = price - (price * discount / 100);
            System.out.println("\nProduct ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discounted Price: " + discountedPrice);
        }
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            int productID = sc.nextInt();
            sc.nextLine();
            String productName = sc.nextLine();
            double price = sc.nextDouble();
            int quantity = sc.nextInt();
            sc.nextLine();

            products[i] = new Product(productID, productName, price, quantity);
        }

        double newDiscount = sc.nextDouble();
        updateDiscount(newDiscount);

        for (int i = 0; i < n; i++) {
            products[i].displayProductDetails();
        }


    }
}
