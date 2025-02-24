import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class Hello implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args);
    }
}

public class ReflectionLoggingProxy {
    public static void main(String[] args) {
        Greeting original = new Hello();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(original)
        );
        proxyInstance.sayHello();
    }
}
