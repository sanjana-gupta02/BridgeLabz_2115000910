import java.util.*;

public class RandomNumberAnalysis {
    static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) numbers[i] = 1000 + (int) (Math.random() * 9000);
        return numbers;
    }

    static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return new double[]{sum / (double) numbers.length, min, max};
    }

    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);
        double[] results = findAverageMinMax(numbers);

        System.out.println("Generated Numbers: " + Arrays.toString(numbers));
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f\n", results[0], results[1], results[2]);
    }
}
