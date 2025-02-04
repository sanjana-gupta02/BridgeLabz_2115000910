import java.util.Random;

public class EmployeeBonus {

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData();
        double[][] bonusData = calculateBonus(employeeData);

        displaySalaryAndBonus(employeeData, bonusData);
    }

    public static double[][] generateEmployeeData() {
        Random random = new Random();
        double[][] employeeData = new double[10][2]; // Salary, Years of Service

        for (int i = 0; i < 10; i++) {
            employeeData[i][0] = 10000 + random.nextInt(90000); // Salary between 10000 and 99999
            employeeData[i][1] = random.nextInt(10); // Years of service between 0 and 9
        }
        return employeeData;
    }

    public static double[][] calculateBonus(double[][] employeeData) {
        double[][] bonusData = new double[10][2]; // New Salary, Bonus Amount

        for (int i = 0; i < 10; i++) {
            double salary = employeeData[i][0];
            int years = (int) employeeData[i][1];
            double bonusPercentage = (years > 5) ? 0.05 : 0.02;
            double bonusAmount = salary * bonusPercentage;
            double newSalary = salary + bonusAmount;

            bonusData[i][0] = newSalary;
            bonusData[i][1] = bonusAmount;
        }
        return bonusData;
    }

    public static void displaySalaryAndBonus(double[][] employeeData, double[][] bonusData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonusAmount = 0;

        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", "Employee", "Old Salary", "Years of Service", "New Salary", "Bonus Amount");
        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            int years = (int) employeeData[i][1];
            double newSalary = bonusData[i][0];
            double bonusAmount = bonusData[i][1];

            System.out.printf("%-10d %-15.2f %-15d %-15.2f %-15.2f\n", i + 1, oldSalary, years, newSalary, bonusAmount);

            totalOldSalary += oldSalary;
            totalNewSalary += newSalary;
            totalBonusAmount += bonusAmount;
        }

        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-10s %-15.2f %-15s %-15.2f %-15.2f\n", "Total", totalOldSalary, "", totalNewSalary, totalBonusAmount);
        System.out.println("--------------------------------------------------------------------");
    }
}