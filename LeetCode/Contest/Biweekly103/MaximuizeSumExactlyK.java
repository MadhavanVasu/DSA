package LeetCode.Contest.Biweekly103;

import java.util.Arrays;

public class MaximuizeSumExactlyK {

    public int maximizeSum(int[] nums, int k) {
        int max = Arrays.stream(nums).max().orElse(0);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += max;
            max++;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
