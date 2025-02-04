import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] studentScores = generateRandomScores(numStudents);
        double[][] results = calculateResults(studentScores);

        displayScorecard(studentScores, results);
        scanner.close();
    }

    public static int[][] generateRandomScores(int numStudents) {
        Random random = new Random();
        int[][] studentScores = new int[numStudents][3]; // Physics, Chemistry, Math

        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                studentScores[i][j] = 10 + random.nextInt(90); // Scores between 10 and 99
            }
        }
        return studentScores;
    }

    public static double[][] calculateResults(int[][] studentScores) {
        double[][] results = new double[studentScores.length][4]; // Total, Average, Percentage, rounded average

        for (int i = 0; i < studentScores.length; i++) {
            int physics = studentScores[i][0];
            int chemistry = studentScores[i][1];
            int math = studentScores[i][2];

            int total = physics + chemistry + math;
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;
            double roundedAverage = Math.round(average * 100.0) / 100.0; // Round to 2 decimal places

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
            results[i][3] = roundedAverage;
        }
        return results;
    }

    public static void displayScorecard(int[][] studentScores, double[][] results) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < studentScores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\n",
                    i + 1, studentScores[i][0], studentScores[i][1], studentScores[i][2],
                    results[i][0], results[i][3], results[i][2]);
        }
        System.out.println("--------------------------------------------------------------------");
    }
}