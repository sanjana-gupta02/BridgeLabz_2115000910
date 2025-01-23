import java.util.Scanner;

public class FriendComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ageAmar = sc.nextInt();
        double heightAmar = sc.nextDouble();
        int ageAkbar = sc.nextInt();
        double heightAkbar = sc.nextDouble();
        int ageAnthony = sc.nextInt();
        double heightAnthony = sc.nextDouble();

        int youngestAge = ageAmar;
        String youngestFriend = "Amar";
        double tallestHeight = heightAmar;
        String tallestFriend = "Amar";

        if (ageAkbar < youngestAge) {
            youngestAge = ageAkbar;
            youngestFriend = "Akbar";
        }
        if (ageAnthony < youngestAge) {
            youngestAge = ageAnthony;
            youngestFriend = "Anthony";
        }

        if (heightAkbar > tallestHeight) {
            tallestHeight = heightAkbar;
            tallestFriend = "Akbar";
        }
        if (heightAnthony > tallestHeight) {
            tallestHeight = heightAnthony;
            tallestFriend = "Anthony";
        }

        System.out.println(youngestFriend + " is the youngest.");
        System.out.println(tallestFriend + " is the tallest.");
    }
}
