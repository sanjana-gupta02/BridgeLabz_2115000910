import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Sanjana Gupta")
class Book {
    void display() {
        System.out.println("Book class method executed");
    }
}

public class ReflectionAnnotation {
    public static void main(String[] args) {
        Class<?> cls = Book.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}
