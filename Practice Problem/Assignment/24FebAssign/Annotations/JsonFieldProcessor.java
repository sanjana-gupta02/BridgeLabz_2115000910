import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Person {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public Person(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                try {
                    jsonMap.put(field.getAnnotation(JsonField.class).name(), field.get(this).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        StringBuilder json = new StringBuilder("{");
        jsonMap.forEach((key, value) -> json.append("\"").append(key).append("\": \"").append(value).append("\", "));
        if (!jsonMap.isEmpty()) json.setLength(json.length() - 2);
        json.append("}");
        return json.toString();
    }
}

public class JsonFieldProcessor {
    public static void main(String[] args) {
        Person user = new Person("Sanjana", 20);
        System.out.println(user.toJson());
    }
}
