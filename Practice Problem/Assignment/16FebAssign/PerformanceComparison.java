public class PerformanceComparison {

    public static long concatUsingBuffer(int n) {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long concatUsingBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        int n = 1000000;
        long timeBuffer = concatUsingBuffer(n);
        long timeBuilder = concatUsingBuilder(n);
        System.out.println("Time using StringBuffer: " + timeBuffer / 1000000 + " ms");
        System.out.println("Time using StringBuilder: " + timeBuilder / 1000000 + " ms");
    }
}
