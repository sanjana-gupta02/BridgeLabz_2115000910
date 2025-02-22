public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String text = "This    is  an     example   with  multiple spaces.";
        String replacedText = text.replaceAll("\\s+", " ");  // Replace multiple spaces with a single space

        System.out.println("Original: " + text);
        System.out.println("Formatted: " + replacedText);
    }
}
