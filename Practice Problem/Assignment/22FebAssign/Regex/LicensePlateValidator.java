import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        String regex = "^[A-Z]{2}\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        String[] plates = {"AB1234", "A12345", "XYZ123", "CD5678", "ab1234"};

        for (String plate : plates) {
            System.out.println(plate + " is valid: " + pattern.matcher(plate).matches());
        }
    }
}
