import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int temp = number;
        int digitCount = 0;

        while (temp != 0) {
            digitCount++;
            temp = temp / 10;
        }

        int[] digits = new int[digitCount];
        int index = 0;

        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }
    }
}
