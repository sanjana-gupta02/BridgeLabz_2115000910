public class ReverseString {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString(); //returning reversed string to main method
    }

    public static void main(String[] args) {
        String input = "Sanjana";
        String reversed = reverse(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
    }
}
