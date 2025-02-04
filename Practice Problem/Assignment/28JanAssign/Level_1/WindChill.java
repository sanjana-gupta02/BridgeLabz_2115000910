import java.util.Scanner;

public class WindChill {

    public double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();

        WindChill windChillCalculator = new WindChill();
        double windChill = windChillCalculator.calculateWindChill(temperature, windSpeed);

        System.out.println("Wind Chill Temperature: " + windChill);
    }
}
