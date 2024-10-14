package LeetCode.Contest.Weekly415;

import java.util.HashSet;
import java.util.Set;

public class TwoSneakyNumbersOfDigitville {

    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] result = new int[2];
        int j = 0;
        for (int x : nums) {
            if (!set.contains(x)) set.add(x);
            else result[j++] = x;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
