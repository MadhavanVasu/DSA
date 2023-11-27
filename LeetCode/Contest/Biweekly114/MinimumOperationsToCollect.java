package LeetCode.Contest.Biweekly114;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationsToCollect {

    public int minOperations(List<Integer> nums, int k) {

        Set<Integer> set = new HashSet<>();
        int collected = 0;
        int i;
        for (i = nums.size() - 1; i >= 0; i--) {
            if (nums.get(i) <= k && !set.contains(nums.get(i))) {
                set.add(nums.get(i));
                collected += 1;
            }
            if (collected == k) break;
        }
        return nums.size() - i;
    }

    public static void main(String[] args) {

    }

}
