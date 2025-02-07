interface Worker {
    void performDuties();
}

class Persons {
    private String name;
    private int id;

    Persons(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

class Chef extends Persons implements Worker {
    private String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    public void performDuties() {
        System.out.println("Chef is preparing dishes, specializing in " + specialty);
    }
}

class Waiter extends Persons implements Worker {
    private int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    public void performDuties() {
        System.out.println("Waiter is serving customers at " + tablesAssigned + " tables.");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Sanjana", 101, "Indian Food");
        Waiter waiter = new Waiter("Kislay", 202, 5);

        chef.displayInfo();
        chef.performDuties();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
