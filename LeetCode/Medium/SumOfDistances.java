package LeetCode.Medium;

import java.util.*;

public class SumOfDistances {

    public static long[] distance(int[] nums) {

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        int n = nums.length;
        long[] result = new long[n];
        for (int x : nums) indexMap.put(x, new ArrayList<>());
        for (int i = 0; i < n; i++) indexMap.get(nums[i]).add(i);
        for (int x : indexMap.keySet()) {
            if (indexMap.get(x).size() != 1) {
                List<Integer> indices = indexMap.get(x);
                int len = indices.size();
                long sum = 0;
                for (int i = len - 2; i >= 0; i--)
                    sum += ((long) indices.get(len - 1) - indices.get(i));
                result[indices.get(len - 1)] = sum;
                for (int i = len - 2; i >= 0; i--) {
                    int prev = indices.get(i + 1);
                    long prevSum = result[prev];
                    int eleAfter = indices.size() - i - 2;
                    int diff = prev - indices.get(i);
                    prevSum += ((long) eleAfter * diff);
                    prevSum -= ((long) i * diff);
                    result[indices.get(i)] = prevSum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        int[] nums = {1, 3, 1, 1, 2};
        int[] nums = {1, 0, 1, 1, 1, 0, 1};
        System.out.println(Arrays.toString(distance(nums)));

    }

}
