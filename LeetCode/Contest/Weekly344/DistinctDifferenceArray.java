package LeetCode.Contest.Weekly344;

import java.util.HashSet;
import java.util.Set;

public class DistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) set1.add(nums[j]);
            for (int j = i + 1; j < n; j++) set2.add(nums[j]);
            result[i] = set1.size() - set2.size();
            set1.clear();
            set2.clear();
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
