package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        long sum = 0;
        Map<Long, Integer> sumCount = new HashMap<>();
        for (int x : nums) {
            sum += x;
            if (sum == k) res++;
            res += (sumCount.getOrDefault(sum - k, 0));
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
        }
        return res;

    }

    public static void main(String[] args) {

    }

}
