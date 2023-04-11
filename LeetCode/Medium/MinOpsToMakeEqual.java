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
        prefixArray[0] = nums[0];
        for (int i = 1; i < n; i++) prefixArray[i] = prefixArray[i - 1] + nums[i];
        List<Long> result = new ArrayList<>();
        for (int x : queries) {
            int pos = binarySearch(0, n - 1, nums, x);
            long left = pos >= 0 ? ((long) x * (pos + 1)) - prefixArray[pos] : 0;
            long right = pos + 1 < n ? prefixArray[n - 1] - pos == -1 ? 0 : prefixArray[pos] - (long) x * (n - pos - 1) : 0;
            result.add(left + right);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 6, 8};
        int[] queries = {1, 5};
        System.out.println(minOperations(nums, queries));
        int a = 1;
//        System.out.println((a++ + a));
//        System.out.println(a);

    }

}
