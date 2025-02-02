public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newRegistrationFee) {
        registrationFee = newRegistrationFee;
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Sanjana", "Car");
        Vehicle vehicle2 = new Vehicle("Khushi", "Bike");

        Vehicle.updateRegistrationFee(5000);

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
