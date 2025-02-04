import java.util.*;

public class BMIAnalysis {
    static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100;
        return weight / (heightM * heightM);
    }

    static String getBMIStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] members = new double[10][3];

        for (int i = 0; i < 10; i++) {
            members[i][0] = sc.nextDouble();
            members[i][1] = sc.nextDouble();
            members[i][2] = calculateBMI(members[i][0], members[i][1]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d -> Height: %.2f cm, Weight: %.2f kg, BMI: %.2f, Status: %s\n",
                    i + 1, members[i][1], members[i][0], members[i][2], getBMIStatus(members[i][2]));
        }
    }
}
