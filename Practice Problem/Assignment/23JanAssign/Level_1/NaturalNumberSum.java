import java.util.Scanner;

public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            int sumByFormula = n * (n + 1) / 2;

            int sumByLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumByLoop += i;
            }

            System.out.println("Sum by formula: " + sumByFormula);
            System.out.println("Sum by loop: " + sumByLoop);
            System.out.println("Results match: " + (sumByFormula == sumByLoop));
        }
    }
}
