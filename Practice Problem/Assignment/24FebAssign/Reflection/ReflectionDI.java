import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    void execute() {
        System.out.println("Service executed!");
    }
}

class Controller {
    @Inject
    private Service service;

    void run() {
        service.execute();
    }
}

class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = field.getType().getDeclaredConstructor().newInstance();
                field.set(obj, dependency);
            }
        }
    }
}

public class ReflectionDI {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        DIContainer.injectDependencies(controller);
        controller.run();
    }
}
