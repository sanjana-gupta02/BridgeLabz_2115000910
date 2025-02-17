import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] leftArr = new int[n1], rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int datasetSize = 100000;
        int[] data1 = new int[datasetSize];
        int[] data2 = new int[datasetSize];
        int[] data3 = new int[datasetSize];
        Random rand = new Random();

        for (int i = 0; i < datasetSize; i++) {
            int num = rand.nextInt(1000000);
            data1[i] = num;
            data2[i] = num;
            data3[i] = num;
        }

        // Bubble Sort Timing
        long start = System.nanoTime();
        bubbleSort(data1);
        long bubbleTime = System.nanoTime() - start;
        System.out.println("Bubble Sort Time: " + bubbleTime / 1e6 + " ms");

        // Merge Sort Timing
        start = System.nanoTime();
        mergeSort(data2, 0, datasetSize - 1);
        long mergeTime = System.nanoTime() - start;
        System.out.println("Merge Sort Time: " + mergeTime / 1e6 + " ms");

        // Quick Sort Timing
        start = System.nanoTime();
        quickSort(data3, 0, datasetSize - 1);
        long quickTime = System.nanoTime() - start;
        System.out.println("Quick Sort Time: " + quickTime / 1e6 + " ms");
    }
}
