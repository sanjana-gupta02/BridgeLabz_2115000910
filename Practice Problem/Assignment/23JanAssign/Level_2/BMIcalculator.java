import java.util.Scanner;

public class BMIcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();
        double heightCm = sc.nextDouble();

        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);

        if (bmi <= 18.4) {
            System.out.println("BMI: " + bmi + " - Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("BMI: " + bmi + " - Normal");
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            System.out.println("BMI: " + bmi + " - Overweight");
        } else {
            System.out.println("BMI: " + bmi + " - Obese");
        }
    }
}
