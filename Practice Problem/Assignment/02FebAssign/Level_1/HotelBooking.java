import java.util.Scanner;

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void displayBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HotelBooking booking1 = new HotelBooking();
        booking1.displayBookingDetails();

        String guestName = sc.nextLine();
        String roomType = sc.nextLine();
        int nights = sc.nextInt();

        HotelBooking booking2 = new HotelBooking(guestName, roomType, nights);
        booking2.displayBookingDetails();

        HotelBooking booking3 = new HotelBooking(booking2);
        booking3.displayBookingDetails();

        sc.close();
    }
}
