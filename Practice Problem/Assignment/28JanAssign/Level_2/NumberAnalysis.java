import java.util.*;

public class NumberAnalysis {
    static boolean isPositive(int num) {
        return num >= 0;
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    static int compare(int num1, int num2) {
        return Integer.compare(num1, num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) numbers[i] = sc.nextInt();

        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.println(num + " is Positive");
                System.out.println(num + (isEven(num) ? " is Even" : " is Odd"));
            } else System.out.println(num + " is Negative");
        }

        int result = compare(numbers[0], numbers[4]);
        if (result == 0) System.out.println("First and Last elements are Equal");
        else if (result > 0) System.out.println("First element is Greater than Last");
        else System.out.println("First element is Less than Last");
    }
}
