package LeetCode.Contest.Weekly349;

import java.util.Arrays;

public class NeitherMinimumNorMaximum {

    public int findNonMinOrMax(int[] nums) {

        if (nums.length == 1 || nums.length == 2) return -1;

        int min = Arrays.stream(nums).min().orElse(-1);
        int max = Arrays.stream(nums).max().orElse(-1);

        for (int x : nums)
            if (x != min && x != max) return x;
        return -1;
    }

    public static void main(String[] args) {

    }

}
