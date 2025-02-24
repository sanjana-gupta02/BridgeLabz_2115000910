import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed!");
    }
}

class Users {
    private String role;

    public Users(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

public class RoleAccessProcessor {
    public static void main(String[] args) throws Exception {
        Users user1 = new Users("ADMIN");
        Users user2 = new Users("USER");

        executeMethodIfAllowed(user1, "adminTask");
        executeMethodIfAllowed(user2, "adminTask");
    }

    public static void executeMethodIfAllowed(Users user, String methodName) throws Exception {
        SecureService service = new SecureService();
        Method method = SecureService.class.getMethod(methodName);

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            String requiredRole = method.getAnnotation(RoleAllowed.class).value();
            if (user.getRole().equals(requiredRole)) {
                method.invoke(service);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
