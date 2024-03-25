package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousSubarray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) sum -= 1;
            else sum += 1;
            if (sum == 0) result = i + 1;
            if (sumMap.containsKey(sum)) {
                int len = i - sumMap.get(sum);
                if (len > result) result = len;
            } else sumMap.put(sum, i);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
