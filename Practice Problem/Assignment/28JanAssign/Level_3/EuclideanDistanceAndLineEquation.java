import java.util.Arrays;
import java.util.Scanner;

public class EuclideanDistanceAndLineEquation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean distance: " + distance);

        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        double slope = lineEquation[0];
        double yIntercept = lineEquation[1];

        if (Double.isInfinite(slope)) {
            System.out.println("The line is vertical: x = " + x1);
        } else {
            System.out.println("Equation of the line: y = " + slope + "x + " + yIntercept);
        }

        scanner.close();
    }

    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope;
        if (x2 - x1 == 0) {
            slope = Double.POSITIVE_INFINITY;
        } else {
            slope = (y2 - y1) / (x2 - x1);
        }

        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }
}