import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionDynamicMethod {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = sc.next();
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        sc.close();

        MathOperations obj = new MathOperations();
        Class<?> cls = obj.getClass();
        Method method = cls.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(obj, a, b);
        System.out.println("Result: " + result);
    }
}
