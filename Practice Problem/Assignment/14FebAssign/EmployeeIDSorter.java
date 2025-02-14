import java.util.Scanner;
import java.util.Arrays;

public class EmployeeIDSorter {
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i], j = i - 1;
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] employeeIDs = new int[n];

        for (int i = 0; i < n; i++){
            employeeIDs[i] = sc.nextInt();
        }

        insertionSort(employeeIDs);
        System.out.println(Arrays.toString(employeeIDs));
    }
}
