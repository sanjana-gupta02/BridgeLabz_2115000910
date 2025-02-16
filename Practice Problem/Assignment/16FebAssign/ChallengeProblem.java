public class ChallengeProblem {

    static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] seen = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n) {
                seen[arr[i]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                return i;
            }
        }
        return n + 1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrForMissingPositive = {3, 4, -1, 1};
        int firstMissing = findFirstMissingPositive(arrForMissingPositive);
        System.out.println("First missing positive: " + firstMissing);

        int[] sortedArr = {-1, 1, 3, 4, 6, 7, 9};
        int target = 6;
        int targetIndex = binarySearch(sortedArr, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}
