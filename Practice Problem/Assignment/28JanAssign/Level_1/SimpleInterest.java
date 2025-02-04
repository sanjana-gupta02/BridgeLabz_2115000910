import java.util.Scanner;

public class SimpleInterest {
    public double calculate(double principal, double rate, double time){
        return principal * rate * time / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principal, Rate and Time: ");
        double principal = sc.nextDouble();
        double rate = sc.nextDouble();
        double time = sc.nextDouble();

        SimpleInterest obj = new SimpleInterest();
        double res = obj.calculate(principal, rate, time);
        System.out.println("Simple Interest: " +res);
    }
}
