import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class ReflectionPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<?> cls = p.getClass();
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println("Old Value: " + field.get(p));
        field.set(p, 30);
        System.out.println("New Value: " + field.get(p));
    }
}
