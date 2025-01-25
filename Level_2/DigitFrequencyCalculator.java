import java.util.Scanner;

public class DigitFrequencyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int[] digits = new int[10];
        int[] frequency = new int[10];

        int index = 0;
        while (number != 0) {
            digits[index++] = number % 10;
            number /= 10;
        }

        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }

        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }
    }
}

