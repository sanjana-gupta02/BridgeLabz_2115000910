import java.util.*;

class PairWithGivenSum {
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: (" + num + ", " + (target - num) + ")");
                return true;
            }
            set.add(num);
        }
        System.out.println("No pair found");
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 4, 8};
        int target = 9;
        hasPairWithSum(nums, target);
    }
}
