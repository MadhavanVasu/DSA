package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int max = 0;
        for (int x : nums) {
            if (!set.contains(x - 1)) {
                int count = 1;
                int next = x + 1;
                while (true) {
                    if (set.contains(next)) {
                        count++;
                        next++;
                    } else break;
                }
                if (count > max) max = count;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
