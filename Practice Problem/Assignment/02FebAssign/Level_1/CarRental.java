class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double rentalCost;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateCost();
    }

    private void calculateCost() {
        double dailyRate = 50; // Assuming $50 per day rental rate
        rentalCost = rentalDays * dailyRate;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Rental Cost: $" + rentalCost);
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Sanjana", "Audi", 5);
        rental.displayRentalDetails();
    }
}
