import java.util.regex.*;

public class UsernameValidator {
    public static void main(String[] args) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        String[] usernames = {"user_123", "123user", "us", "Valid_User1", "toolongusername123"};

        for (String username : usernames) {
            System.out.println(username + " is valid: " + pattern.matcher(username).matches());
        }
    }
}
