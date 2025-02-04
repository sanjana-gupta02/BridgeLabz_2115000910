import java.util.Scanner;

public class HandShake {
    public int calculate(int n){
        return (n * (n - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = sc.nextInt();
        HandShake obj = new HandShake();
        System.out.println("No. of HandShakes is: " +obj.calculate(n));
    }
}
