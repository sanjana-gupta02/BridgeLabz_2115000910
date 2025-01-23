import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();

        double result = 0;
        boolean validOperator = true;

        switch (op) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                } else {
                    validOperator = false;
                    System.out.println("Cannot divide by zero.");
                }
                break;
            default:
                validOperator = false;
                System.out.println("Invalid Operator.");
                break;
        }

        if (validOperator) {
            System.out.println(result);
        }
    }
}
