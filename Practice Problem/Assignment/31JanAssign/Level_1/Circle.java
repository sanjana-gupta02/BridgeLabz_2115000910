import java.util.Scanner;

public class Circle {
    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    public void displayResult(){
        double area = 3.14*radius*radius;
        double circumference = 2*3.14*radius;
        System.out.println("Area of Circle: " +area+ "\n" + "Circumference of Circle " +circumference);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius:");
        int radius = sc.nextInt();
        Circle obj = new Circle(radius);
        obj.displayResult();
    }


}
