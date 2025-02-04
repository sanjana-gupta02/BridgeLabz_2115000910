import java.util.*;

public class FootballTeamHeightAnalysis {
    static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) heights[i] = 150 + (int) (Math.random() * 101);
        return heights;
    }

    static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) sum += height;
        return sum;
    }

    static double findMeanHeight(int[] heights) {
        return findSum(heights) / (double) heights.length;
    }

    static int findShortest(int[] heights) {
        int min = heights[0];
        for (int height : heights) min = Math.min(min, height);
        return min;
    }

    static int findTallest(int[] heights) {
        int max = heights[0];
        for (int height : heights) max = Math.max(max, height);
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11);
        System.out.println("Player Heights: " + Arrays.toString(heights));
        System.out.printf("Shortest: %d cm, Tallest: %d cm, Mean Height: %.2f cm\n", findShortest(heights), findTallest(heights), findMeanHeight(heights));
    }
}
