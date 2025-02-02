import java.util.Scanner;

class Circle {
    private double radius;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void displayRadius() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Circle circle1 = new Circle();
        circle1.displayRadius();

        double radius = sc.nextDouble();
        Circle circle2 = new Circle(radius);
        circle2.displayRadius();

        sc.close();
    }
}
