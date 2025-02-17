import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int datasetSize = 1000000;
        int[] data = new int[datasetSize];
        Random rand = new Random();
        for (int i = 0; i < datasetSize; i++) {
            data[i] = rand.nextInt(10000000);
        }

        int target = data[rand.nextInt(datasetSize)];

        long startTime = System.nanoTime();
        int linearResult = linearSearch(data, target);
        long linearTime = System.nanoTime() - startTime;
        System.out.println("Linear Search result: " + linearResult + ", Time: " + linearTime / 1e6 + " ms");

        startTime = System.nanoTime();
        Arrays.sort(data);  // O(N log N)
        long sortTime = System.nanoTime() - startTime;
        System.out.println("Sorting Time: " + sortTime / 1e6 + " ms");

        startTime = System.nanoTime();
        int binaryResult = binarySearch(data, target);
        long binaryTime = System.nanoTime() - startTime;
        System.out.println("Binary Search result: " + binaryResult + ", Time: " + binaryTime / 1e6 + " ms");
    }
}
