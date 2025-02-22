import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};  // Add more bad words if needed

        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");  // (?i) makes it case-insensitive
        }

        System.out.println("Censored Text: " + text);
    }
}
