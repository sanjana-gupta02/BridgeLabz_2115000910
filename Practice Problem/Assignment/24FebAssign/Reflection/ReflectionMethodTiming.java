import java.lang.reflect.Method;

class SampleOperations {
    public void fastMethod() {
        System.out.println("Fast method executed!");
    }

    public void slowMethod() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Slow method executed!");
    }
}

class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName, Class<?>... paramTypes) throws Exception {
        Method method = obj.getClass().getMethod(methodName, paramTypes);
        long startTime = System.nanoTime();
        method.invoke(obj);
        long endTime = System.nanoTime();
        System.out.println(methodName + " executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}

public class ReflectionMethodTiming {
    public static void main(String[] args) throws Exception {
        SampleOperations obj = new SampleOperations();
        MethodTimer.measureExecutionTime(obj, "fastMethod");
        MethodTimer.measureExecutionTime(obj, "slowMethod");
    }
}
