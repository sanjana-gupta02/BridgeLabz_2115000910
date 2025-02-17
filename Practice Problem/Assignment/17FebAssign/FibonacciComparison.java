public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30;

        long startTime = System.nanoTime();
        int resultRecursive = fibonacciRecursive(n);
        long recursiveTime = System.nanoTime() - startTime;
        System.out.println("Recursive Fibonacci (" + n + "): " + resultRecursive
                + ", Time: " + recursiveTime / 1e6 + " ms");

        startTime = System.nanoTime();
        int resultIterative = fibonacciIterative(n);
        long iterativeTime = System.nanoTime() - startTime;
        System.out.println("Iterative Fibonacci (" + n + "): " + resultIterative
                + ", Time: " + iterativeTime / 1e6 + " ms");
    }
}
