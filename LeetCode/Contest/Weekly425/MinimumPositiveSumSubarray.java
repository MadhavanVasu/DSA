package LeetCode.Contest.Weekly425;

import java.util.List;

public class MinimumPositiveSumSubarray {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = -1;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            int tempSum = sum;
            for (int j = 0; j <= i; j++) {
                int len = i - j + 1;
                if (len >= l && len <= r) {
                    if (tempSum > 0) {
                        if (min == -1 || tempSum < min) min = tempSum;
                    }
                }
                tempSum -= nums.get(j);
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }

}
