import java.lang.reflect.*;

public class ReflectionInfo {
    public static void main(String[] args) throws Exception {
        // Accept class name as input
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = sc.nextLine();
        sc.close();

        // Load the class dynamically
        Class<?> cls = Class.forName(className);

        // Display class name
        System.out.println("\nClass: " + cls.getName());

        // Display fields
        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        // Display methods
        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }

        // Display constructors
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
    }
}
