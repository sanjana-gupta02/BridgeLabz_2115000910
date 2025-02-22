import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {
        String regex = "^#([A-Fa-f0-9]{6})$";
        Pattern pattern = Pattern.compile(regex);

        String[] colors = {"#FFA500", "#ff4500", "#123", "#00ff99", "#ABC123", "123456"};

        for (String color : colors) {
            System.out.println(color + " is valid: " + pattern.matcher(color).matches());
        }
    }
}
