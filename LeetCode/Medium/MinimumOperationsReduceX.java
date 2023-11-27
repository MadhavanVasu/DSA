package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsReduceX {

    public int minOperations(int[] nums, int x) {

        int n = nums.length;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        Map<Long, Integer> suffixSum = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum == x) min = n - i;
            suffixSum.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum > x) break;
            else if (sum == x) {
                min = Math.min(min, i + 1);
            } else if (suffixSum.containsKey(x - sum)) {
                int index = suffixSum.get(x - sum);
                if (index > i)
                    min = Math.min(min, i + 1 + (n - index));
            }
        }
        if (min == Integer.MAX_VALUE) min = -1;
        return min;
    }

    public static void main(String[] args) {

        int[] nums = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        int x = 134365;
        System.out.println(new MinimumOperationsReduceX().minOperations(nums, x));

    }

}
