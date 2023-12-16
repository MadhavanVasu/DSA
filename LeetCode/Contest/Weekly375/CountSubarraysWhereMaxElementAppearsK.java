package LeetCode.Contest.Weekly375;

import java.util.ArrayList;
import java.util.List;

public class CountSubarraysWhereMaxElementAppearsK {

    public long countSubarrays(int[] nums, int k) {
        List<Integer> maxElementIndices = new ArrayList<>();
        int count = 0;
        int max = 0;
        int n = nums.length;
        for (int x : nums) if (x > max) max = x;
        long result = 0;
        int i;
        for (i = 0; i < n; i++) {
            if (nums[i] == max) {
                maxElementIndices.add(i);
                count++;
                if (count > k) {
                    int right = i - maxElementIndices.get(count - 2);
                    int left = maxElementIndices.get(count - 2 - k - 1);
                    result += ((long) left * right);
                }
            }
        }
        if (count == k || count > k) {
            int right = i - maxElementIndices.get(count - 2);
            int left = maxElementIndices.get(count - 2 - k - 1);
            result += ((long) left * right);
        }
        return result;
    }

    public static void main(String[] args) {
        // { 1, 4, 2, 3, 4, 4, 1, 3, 4, 1 ,4, 1}
        // [61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82]
        // 2
        // 7 + 10 +
//        7 + 2 + 1 + 10 + 2 + 20 + 2
    }

}
