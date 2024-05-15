package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveIntegerWithItsNegative {

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            if (x < 0) set.add(x);
        int result = -1;
        for (int x : nums)
            if (x > 0 && set.contains(-x) && x > result) result = x;
        return result;
    }

    public static void main(String[] args) {

    }

}
