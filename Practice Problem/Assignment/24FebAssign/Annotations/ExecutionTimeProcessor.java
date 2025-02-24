import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class TasksManager {
    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1000; i++); // Simple loop
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 1_000_000; i++); // Longer loop
    }
}

public class ExecutionTimeProcessor {
    public static void main(String[] args) throws Exception {
        TasksManager taskManager = new TasksManager();
        Method[] methods = TasksManager.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(taskManager);
                long end = System.nanoTime();
                System.out.println("Execution Time of " + method.getName() + ": " + (end - start) / 1_000_000.0 + " ms");
            }
        }
    }
}
