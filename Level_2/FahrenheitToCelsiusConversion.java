import java.util.Scanner;

public class FahrenheitToCelsiusConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double fahrenheit = sc.nextDouble();
        double celsiusResult = (fahrenheit - 32) * 5 / 9;
        System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius");
    }
}
