package LeetCode.Medium;

import java.util.*;

public class Four4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int start = j + 1;
                int end = n - 1;
                while (start < end) {
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else
                        end--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum(nums,-294967296));
    }

}
