import java.util.Scanner;
import java.util.Arrays;

public class SalarySorter {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(salaries, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] salaries = new int[n];

        for (int i = 0; i < n; i++){
            salaries[i] = sc.nextInt();
        }

        heapSort(salaries);
        System.out.println(Arrays.toString(salaries));
    }
}
