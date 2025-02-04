import java.util.*;

public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0) return false;
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        StudentVoteChecker obj = new StudentVoteChecker();

        for (int i = 0; i < 10; i++) {
            ages[i] = sc.nextInt();
            System.out.println(obj.canStudentVote(ages[i]) ? "Can vote" : "Cannot vote");
        }
    }
}
