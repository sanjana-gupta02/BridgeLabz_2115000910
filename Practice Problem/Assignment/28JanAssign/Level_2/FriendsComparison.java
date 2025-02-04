import java.util.*;

public class FriendsComparison {
    static int findYoungest(int[] ages) {
        int minAge = ages[0], index = 0;
        for (int i = 1; i < ages.length; i++) if (ages[i] < minAge) minAge = ages[i];
        return minAge;
    }

    static int findTallest(int[] heights) {
        int maxHeight = heights[0];
        for (int i = 1; i < heights.length; i++) if (heights[i] > maxHeight) maxHeight = heights[i];
        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3], heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }

        int youngestAge = findYoungest(ages), tallestHeight = findTallest(heights);

        for (int i = 0; i < 3; i++) if (ages[i] == youngestAge) System.out.println("Youngest: " + names[i]);
        for (int i = 0; i < 3; i++) if (heights[i] == tallestHeight) System.out.println("Tallest: " + names[i]);
    }
}
