public class StringConcatenationComparison {
    public static void main(String[] args) {
        int iterations = 1000000;
        long start;

        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < iterations; i++) {
            str += "a";
        }
        long stringTime = System.nanoTime() - start;
        System.out.println("String Time: " + stringTime / 1e6 + " ms");

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("a");
        }
        long stringBuilderTime = System.nanoTime() - start;
        System.out.println("StringBuilder Time: " + stringBuilderTime / 1e6 + " ms");

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append("a");
        }
        long stringBufferTime = System.nanoTime() - start;
        System.out.println("StringBuffer Time: " + stringBufferTime / 1e6 + " ms");
    }
}
