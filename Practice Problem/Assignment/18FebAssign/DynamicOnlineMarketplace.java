abstract class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Category: " + getCategory();
    }
}

class Book extends Product {
    public Book(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String getCategory() {
        return "Book";
    }
}

class Clothing extends Product {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}

class Gadget extends Product {
    public Gadget(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public String getCategory() {
        return "Gadget";
    }
}

class ProductCatalog<T extends Product> {
    private java.util.List<T> products;

    public ProductCatalog() {
        products = new java.util.ArrayList<>();
    }

    public void addProduct(T product) {
        products.add(product);
    }

    public java.util.List<T> getProducts() {
        return products;
    }
}

class MarketplaceUtils {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();

        bookCatalog.addProduct(new Book("B101", "Java Programming", 50.0));
        bookCatalog.addProduct(new Book("B102", "Data Structures", 40.0));

        clothingCatalog.addProduct(new Clothing("C201", "T-Shirt", 25.0));
        clothingCatalog.addProduct(new Clothing("C202", "Jeans", 45.0));

        gadgetCatalog.addProduct(new Gadget("G301", "Smartphone", 699.0));
        gadgetCatalog.addProduct(new Gadget("G302", "Smartwatch", 199.0));

        System.out.println("Before Discount:");
        for (Book book : bookCatalog.getProducts()) System.out.println(book);
        for (Clothing clothing : clothingCatalog.getProducts()) System.out.println(clothing);
        for (Gadget gadget : gadgetCatalog.getProducts()) System.out.println(gadget);

        MarketplaceUtils.applyDiscount(bookCatalog.getProducts().get(0), 10);
        MarketplaceUtils.applyDiscount(clothingCatalog.getProducts().get(1), 15);
        MarketplaceUtils.applyDiscount(gadgetCatalog.getProducts().get(0), 5);

        System.out.println("\nAfter Discount:");
        for (Book book : bookCatalog.getProducts()) System.out.println(book);
        for (Clothing clothing : clothingCatalog.getProducts()) System.out.println(clothing);
        for (Gadget gadget : gadgetCatalog.getProducts()) System.out.println(gadget);
    }
}
