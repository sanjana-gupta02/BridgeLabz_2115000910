import java.util.Scanner;
import java.util.Arrays;

public class StudentAgeSorter {
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages){
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++){
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            int index = count[ages[i] - minAge] - 1;
            output[index] = ages[i];
            count[ages[i] - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ages = new int[n];

        for (int i = 0; i < n; i++){
            ages[i] = sc.nextInt();
        }

        countingSort(ages, 10, 18);
        System.out.println(Arrays.toString(ages));
    }
}
