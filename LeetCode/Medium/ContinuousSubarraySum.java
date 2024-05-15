package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {


        Map<Long, Integer> remMap = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum % k == 0 && i != 0) return true;
            if (remMap.containsKey(sum % k) && remMap.get(sum % k) != i - 1) return true;
            if (!remMap.containsKey(sum % k))
                remMap.put(sum % k, i);
        }
        return false;
        // Set<Long> remSet = new HashSet<>();
        // long sum = 0;
        // for (int x : nums) {
        //     sum += x;
        //     if (sum % k == 0) return true;
        //     if (remSet.contains(sum % k)) return true;
        //     remSet.add(sum % k);
        // }
        // return false;
    }

    public static void main(String[] args) {

    }

}
