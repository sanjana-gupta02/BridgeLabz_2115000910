import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            if (!seen.contains(input.charAt(i))) {
                sb.append(input.charAt(i));
                seen.add(input.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "Sanjana Gupta";
        String result = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + result);
    }
}
