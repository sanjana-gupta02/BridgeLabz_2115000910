import java.util.*;

public class RotateList {
    public static <T> List<T> rotateList(List<T> list, int rotate) {
        int size = list.size();
        rotate = rotate % size;

        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(rotate, size));
        rotated.addAll(list.subList(0, rotate));

        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        System.out.println("Original List: " + numbers);
        System.out.println("Rotated List: " + rotateList(numbers, rotateBy));
    }
}
