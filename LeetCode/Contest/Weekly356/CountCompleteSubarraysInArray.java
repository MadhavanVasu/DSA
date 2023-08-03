package LeetCode.Contest.Weekly356;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountCompleteSubarraysInArray {

    public int countCompleteSubarrays(int[] nums) {
        int count = 0;
        int distinct = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        distinct = set.size();
        for (int i = 0; i < nums.length; i++) {
            set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() > distinct) break;
                else if (set.size() == distinct) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
