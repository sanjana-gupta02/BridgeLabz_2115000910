public class ExceptionPropagationExample {
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }

    static void method2() {
        method1();
    }

    static void method1() {
        int result = 10 / 0; // Throws ArithmeticException
    }
}
