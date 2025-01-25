import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            age[i] = scanner.nextInt();
            height[i] = scanner.nextDouble();
        }

        int youngestAge = age[0];
        String youngestFriend = friends[0];
        double tallestHeight = height[0];
        String tallestFriend = friends[0];

        for (int i = 1; i < 3; i++) {
            if (age[i] < youngestAge) {
                youngestAge = age[i];
                youngestFriend = friends[i];
            }
            if (height[i] > tallestHeight) {
                tallestHeight = height[i];
                tallestFriend = friends[i];
            }
        }

        System.out.println(youngestFriend);
        System.out.println(tallestFriend);
    }
}
