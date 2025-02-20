import java.util.*;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                throw new IllegalArgumentException("N is larger than the list size.");
            }
        }

        T nthElement = null;
        while (fast.hasNext()) {
            fast.next();
            nthElement = slow.next();
        }

        return nthElement;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        System.out.println("Original List: " + list);
        System.out.println(n + "th element from the end: " + findNthFromEnd(list, n));
    }
}
