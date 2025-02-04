import java.util.*;

public class NumberChecker {
    static int countDigits(int number) {
        int count = 0, temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    static boolean isDuckNumber(int number) {
        while (number > 0) {
            if (number % 10 == 0) return true;
            number /= 10;
        }
        return false;
    }

    static boolean isArmstrongNumber(int number) {
        int[] digits = getDigitsArray(number);
        int power = digits.length, sum = 0, temp = number;
        for (int digit : digits) sum += Math.pow(digit, power);
        return sum == temp;
    }

    static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] digits = getDigitsArray(number);

        System.out.println("Digit Count: " + countDigits(number));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck Number: " + isDuckNumber(number));
        System.out.println("Armstrong Number: " + isArmstrongNumber(number));

        int[] largestPair = findLargestAndSecondLargest(digits);
        int[] smallestPair = findSmallestAndSecondSmallest(digits);
        System.out.printf("Largest: %d, Second Largest: %d\n", largestPair[0], largestPair[1]);
        System.out.printf("Smallest: %d, Second Smallest: %d\n", smallestPair[0], smallestPair[1]);
    }
}
