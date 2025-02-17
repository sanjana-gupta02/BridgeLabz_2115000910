import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int N = 1000000;
        int target = N - 1;
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long startTime = System.nanoTime();
        boolean foundInArray = linearSearch(array, target);
        long arrayTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        long hashSetTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        long treeSetTime = System.nanoTime() - startTime;

        System.out.println("Array Search Time (O(N)): " + arrayTime / 1e6 + " ms");
        System.out.println("HashSet Search Time (O(1)): " + hashSetTime / 1e6 + " ms");
        System.out.println("TreeSet Search Time (O(log N)): " + treeSetTime / 1e6 + " ms");
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}
