import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Application {
    @ImportantMethod(level = "CRITICAL")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod
    public void saveData() {
        System.out.println("Saving data...");
    }

    public void helperMethod() {
        System.out.println("Helper method (not marked important).");
    }
}

public class ImportantMethodProcessor {
    public static void main(String[] args) throws Exception {
        Method[] methods = Application.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " | Level: " + annotation.level());
            }
        }
    }
}
