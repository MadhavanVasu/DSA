package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubarrayOf1s {

    public int longestSubarray(int[] nums) {
        int prev = 0;
        int curr = 0;
        int max = 0;
        boolean zero = false;
        for (int x : nums) {
            if (x == 1) {
                curr++;
            } else {
                int total = prev + curr;
                if (total > max)
                    max = total;
                prev = curr;
                curr = 0;
                zero = true;
            }
        }
        if (!zero) {
            if (curr != 0)
                return curr - 1;
        }
        int total = prev + curr;
        if (total > max)
            max = total;
        return max;
    }

    public static void main(String[] args) {

        int[] candies = {1,2,3,1,4};
        Arrays.stream(candies).sorted().toArray();

    }

}
