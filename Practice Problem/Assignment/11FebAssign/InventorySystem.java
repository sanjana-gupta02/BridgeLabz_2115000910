class ItemNode {
    int itemId, quantity;
    String itemName;
    double price;
    ItemNode next;

    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManager {
    private ItemNode head;

    void addItemAtBeginning(int itemId, String itemName, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        ItemNode newItem = new ItemNode(itemId, itemName, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }

    void removeItemById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) prev.next = temp.next;
    }

    void updateQuantity(int itemId, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    ItemNode searchItemById(int itemId) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) return temp;
            temp = temp.next;
        }
        return null;
    }

    double calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    void displayItems() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println(temp.itemId + " " + temp.itemName + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        inventory.addItemAtEnd(101, "Laptop", 5, 55000);
        inventory.addItemAtEnd(102, "Mouse", 10, 500);
        inventory.addItemAtBeginning(103, "Keyboard", 7, 1500);
        inventory.displayItems();
        System.out.println("Total Inventory Value: " + inventory.calculateTotalValue());
        inventory.updateQuantity(102, 15);
        inventory.displayItems();
        inventory.removeItemById(101);
        inventory.displayItems();
    }
}
