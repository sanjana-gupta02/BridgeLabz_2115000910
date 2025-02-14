import java.util.Scanner;
import java.util.Arrays;

public class ProductPriceSorter {
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] prices, int low, int high) {
        int pivot = prices[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) swap(prices, ++i, j);
            swap(prices, i + 1, high);
        }
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++){
            prices[i] = sc.nextInt();
        }

        quickSort(prices, 0, n - 1);
        System.out.println(Arrays.toString(prices));
    }
}
