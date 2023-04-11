package LeetCode.Medium;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        int min = Integer.MAX_VALUE;
        if (prefix[0] >= target) return 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            if (prefix[i] == target)
                min = Math.min(min, i + 1);
            if (prefix[i] >= target) {
                int start = 0;
                int end = i - 1;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    long diff = prefix[i] - prefix[mid];
                    if (diff >= target) {
                        min = Math.min(min, i - mid);
                        start = mid + 1;
                    } else
                        end = mid - 1;
                }
            }
        }
        min = min == Integer.MAX_VALUE ? 0 : min;
        return min;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,10};
        System.out.println(minSubArrayLen(7, nums));

    }

}
