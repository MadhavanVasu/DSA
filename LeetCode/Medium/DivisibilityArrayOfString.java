package LeetCode.Medium;

import java.util.Arrays;

public class DivisibilityArrayOfString {

    public static int[] divisibilityArray(String word, int m) {

        int n = word.length();
        int[] result = new int[n];
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = num * 10 + Integer.parseInt(String.valueOf(word.charAt(i)));
            System.out.println(num);
            if (num % m == 0) {
                result[i] = 1;
                num = 0;
            } else {
                num = num % m;
                System.out.println(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String word = "123312442564";
        int m = 4;
        System.out.println(Arrays.toString(divisibilityArray(word, m)));

    }
}
