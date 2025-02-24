import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
    String reportedBy();
}

class Software {
    @BugReport(description = "Null pointer exception on login", reportedBy = "Alice")
    @BugReport(description = "UI glitch in dark mode", reportedBy = "Bob")
    public void login() {
        System.out.println("Executing login process...");
    }
}

public class BugReportProcessor {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("login");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description() + " | Reported By: " + bug.reportedBy());
            }
        }

        new Software().login();
    }
}
