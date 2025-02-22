import java.util.regex.*;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(JavaScript|Java|Python|Go|C|C\\+\\+|Ruby|Swift|Kotlin|Rust|PHP)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Language: " + matcher.group());
        }
    }
}
