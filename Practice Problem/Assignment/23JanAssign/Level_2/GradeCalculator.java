import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter marks for the following subjects:");

        System.out.print("Physics: ");
        double physics = scanner.nextDouble();

        System.out.print("Chemistry: ");
        double chemistry = scanner.nextDouble();

        System.out.print("Maths: ");
        double maths = scanner.nextDouble();

        if (physics < 0 || physics > 100 || chemistry < 0 || chemistry > 100 || maths < 0 || maths > 100) {
            System.out.println("Please enter valid marks between 0 and 100.");
            return;
        }

        double totalMarks = physics + chemistry + maths;
        double averageMarks = totalMarks / 3;
        double percentage = (totalMarks / 300) * 100;

        System.out.printf("\nTotal Marks: %.2f / 300\n", totalMarks);
        System.out.printf("Average Marks: %.2f\n", averageMarks);
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage >= 80) {
            System.out.println("Grade: B (Level 4, above agency-normalized standards)");
        } else if (percentage >= 70) {
            System.out.println("Grade: C (Level 3, at agency-normalized standards)");
        } else if (percentage >= 60) {
            System.out.println("Grade: D (Level 2, below, but approaching agency-normalized standards)");
        } else if (percentage >= 50) {
            System.out.println("Grade: E (Level 1, well below agency-normalized standards)");
        } else if (percentage >= 40) {
            System.out.println("Grade: E- (Level 1-, too below agency-normalized standards)");
        } else {
            System.out.println("Grade: Remedial standards (Level 0, 39% and below)");
        }
    }
}
