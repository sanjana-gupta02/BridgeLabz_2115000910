abstract class WarehouseItem {
    private String id;
    private String name;

    public WarehouseItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getDetails();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Details: " + getDetails();
    }
}

class Electronics extends WarehouseItem {
    private int warrantyInMonths;

    public Electronics(String id, String name, int warrantyInMonths) {
        super(id, name);
        this.warrantyInMonths = warrantyInMonths;
    }

    @Override
    public String getDetails() {
        return "Warranty: " + warrantyInMonths + " months";
    }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String id, String name, String expiryDate) {
        super(id, name);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getDetails() {
        return "Expiry Date: " + expiryDate;
    }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String id, String name, String material) {
        super(id, name);
        this.material = material;
    }

    @Override
    public String getDetails() {
        return "Material: " + material;
    }
}

class Storage<T extends WarehouseItem> {
    private java.util.List<T> items;

    public Storage() {
        items = new java.util.ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public java.util.List<T> getItems() {
        return items;
    }
}

class WarehouseUtils {
    public static void displayItems(java.util.List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("E101", "Smartphone", 24));
        electronicsStorage.addItem(new Electronics("E102", "Laptop", 12));

        groceriesStorage.addItem(new Groceries("G201", "Milk", "2025-03-15"));
        groceriesStorage.addItem(new Groceries("G202", "Bread", "2025-02-20"));

        furnitureStorage.addItem(new Furniture("F301", "Chair", "Wood"));
        furnitureStorage.addItem(new Furniture("F302", "Table", "Metal"));

        System.out.println("Electronics:");
        WarehouseUtils.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries:");
        WarehouseUtils.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture:");
        WarehouseUtils.displayItems(furnitureStorage.getItems());
    }
}
