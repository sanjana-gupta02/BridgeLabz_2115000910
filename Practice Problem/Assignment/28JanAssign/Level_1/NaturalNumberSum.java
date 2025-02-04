import java.util.*;

class NaturalNumberSum {
    int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NaturalNumberSum obj = new NaturalNumberSum();
        System.out.println(obj.sumOfNaturalNumbers(n));
    }
}
