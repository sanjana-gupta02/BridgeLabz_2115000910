import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String fromCity = sc.nextLine();
        String viaCity = sc.nextLine();
        String toCity = sc.nextLine();

        double fromToVia = sc.nextDouble();
        double viaToFinalCity = sc.nextDouble();

        int hoursFromToVia = sc.nextInt();
        int minutesFromToVia = sc.nextInt();

        int hoursViaToFinalCity = sc.nextInt();
        int minutesViaToFinalCity = sc.nextInt();

        double totalDistance = fromToVia + viaToFinalCity;

        int totalTimeHours = hoursFromToVia + hoursViaToFinalCity;
        int totalTimeMinutes = minutesFromToVia + minutesViaToFinalCity;

        if (totalTimeMinutes >= 60) {
            totalTimeHours += totalTimeMinutes / 60;
            totalTimeMinutes %= 60;
        }

        System.out.println("\nThe total distance from " + fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " km.");
        System.out.println("The total time taken for the journey is " + totalTimeHours + " hours and " + totalTimeMinutes + " minutes.");
    }
}
