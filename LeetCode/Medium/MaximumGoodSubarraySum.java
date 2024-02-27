package LeetCode.Medium;

import java.util.*;

public class MaximumGoodSubarraySum {

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> indices = indexMap.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            indexMap.put(nums[i], indices);
        }
        long max = Long.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int x : indexMap.keySet()) {
            if (indexMap.containsKey(x - k) && !set.contains(x - k)) {
                for (int index : indexMap.get(x - k)) {
                    sum = Long.MIN_VALUE;
                    for (int ind : indexMap.get(x)) {
                        if (ind > index) {
                            sum = prefixSum[ind] - (index == 0 ? 0 : prefixSum[index - 1]);
                        } else sum = prefixSum[index] - (ind == 0 ? 0 : prefixSum[ind - 1]);
                        if (sum > max) max = sum;
                    }
                }
            }
            if (indexMap.containsKey(x + k) && !set.contains(x + k)) {
                for (int index : indexMap.get(x + k)) {
                    sum = Long.MIN_VALUE;
                    for (int ind : indexMap.get(x)) {
                        if (ind > index) {
                            sum = prefixSum[ind] - (index == 0 ? 0 : prefixSum[index - 1]);
                        } else sum = prefixSum[index] - (ind == 0 ? 0 : prefixSum[ind - 1]);
                        if (sum > max) max = sum;
                    }
                }
            }
            set.add(x);
        }
        return max;
    }

    public static void main(String[] args) {

    }


}
