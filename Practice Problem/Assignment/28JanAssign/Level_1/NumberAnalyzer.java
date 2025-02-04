import java.util.*;

class NumberAnalyzer {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt(), number2 = sc.nextInt(), number3 = sc.nextInt();
        int[] result = findSmallestAndLargest(number1, number2, number3);
        System.out.println(result[0] + " " + result[1]);
    }
}
