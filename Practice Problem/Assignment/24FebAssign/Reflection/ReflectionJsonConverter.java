import java.lang.reflect.Field;

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": \"")
                    .append(fields[i].get(obj)).append("\"");
            if (i < fields.length - 1) json.append(", ");
        }
        return json.append("}").toString();
    }
}

 class Persson {
    private String name = "Alice";
    private int age = 25;
}

public class ReflectionJsonConverter {
    public static void main(String[] args) throws IllegalAccessException {
        Persson person = new Persson();
        System.out.println(JsonSerializer.toJson(person));
    }
}
