public class ConcatStrings {
    public static String concatStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"Sanjana", " ", "Gupta", "!"};
        String result = concatStrings(arr);
        System.out.println(result);
    }
}
