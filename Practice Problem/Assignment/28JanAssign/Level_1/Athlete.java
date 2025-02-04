import java.util.Scanner;

public class Athlete {
    public double calculate(double a, double b, double c){
        double perimeter = a+b+c;
        return 5000/perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the triangular sides in meter");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        Athlete obj = new Athlete();
        System.out.println("Number of rounds: " +obj.calculate(a,b,c));
    }
}
