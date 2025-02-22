import java.util.regex.*;
import java.util.HashSet;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b(?:\\s+\\1\\b)+";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        HashSet<String> uniqueRepeats = new HashSet<>();

        while (matcher.find()) {
            uniqueRepeats.add(matcher.group(1)); // Add only the repeating word
        }

        System.out.println("Repeating Words: " + uniqueRepeats);
    }
}
