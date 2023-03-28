package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinOpsToMakeEqual {

    public static int binarySearch(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return end;
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixArray = new long[n];
        int min = Integer.MAX_VALUE;
        for (int x : queries) min = Math.min(min, x);
        prefixArray[0] = Math.abs((long) nums[0] - min);
        for (int i = 1; i < n; i++) prefixArray[i] = prefixArray[i - 1] + Math.abs(nums[i] - min);
        List<Long> result = new ArrayList<>();
        System.out.println(Arrays.toString(prefixArray));
        for (int x : queries) {
            int pos = binarySearch(0, n - 1, nums, x);
            long left = Math.abs(pos == -1 ? 0 : (long) (x - min) * (pos + 1) - prefixArray[pos]);
            long right = Math.abs(pos + 1 == n ? 0 : (long) (x - min) * (pos + 1) - (prefixArray[n - 1] - prefixArray[pos]));
            result.add(left + right);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 9};
        int[] queries = {10};
        System.out.println(minOperations(nums, queries));
        int a = 1;
        System.out.println((a++ + a));
//        System.out.println(a);

    }

}
