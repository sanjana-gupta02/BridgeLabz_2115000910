import java.util.Scanner;
import java.util.Arrays;

public class ExamScoreSorter {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
                if (scores[j] < scores[minIndex]){
                    minIndex = j;
                }
            swap(scores, i, minIndex);
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
        int[] scores = new int[n];

        for (int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }

        selectionSort(scores);
        System.out.println(Arrays.toString(scores));
    }
}
