package IQns;


// Given an array of nums, find the number of numbers with
// odd number of zero digits in them
public class FindNumberWithOddZeroDigits {

    public int findOddZeroDigitNumbers(int[] numbers) {
        int result = 0;
        for (int x : numbers) {
            if (x == 0) result++;
            else {
                int zeroDigitCount = 0;
                while (x > 0) {
                    if (x % 10 == 0) zeroDigitCount++;
                    x /= 10;
                }
                if (zeroDigitCount % 2 != 0) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
