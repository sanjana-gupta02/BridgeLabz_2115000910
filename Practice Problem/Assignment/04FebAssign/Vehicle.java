import java.util.Scanner;

class Vehicle {
    static double registrationFee = 5000.0;
    final String registrationNumber;
    String ownerName, vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("\nRegistration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String registrationNumber = sc.nextLine();
            String ownerName = sc.nextLine();
            String vehicleType = sc.nextLine();

            vehicles[i] = new Vehicle(registrationNumber, ownerName, vehicleType);
        }

        double newFee = sc.nextDouble();
        updateRegistrationFee(newFee);

        for (int i = 0; i < n; i++) {
            vehicles[i].displayVehicleDetails();
        }

    }
}
