package LeetCode.Medium;

public class MaximumWidthRamp {

    public boolean isFeasible(int[] nums, int gap, int[] maxSuffix) {
        for (int i = 0; i + gap < nums.length; i++) {
            if (nums[i + gap] >= nums[i] || maxSuffix[i + gap] >= nums[i]) return true;
        }
        return false;
    }

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int max = nums[n - 1];
        int[] maxSuffix = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            maxSuffix[i] = max;
            max = Math.max(nums[i], max);
        }
        int start = 0;
        int end = n - 1;
        int maxWidth = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(nums, mid, maxSuffix)) {
                maxWidth = Math.max(maxWidth, mid);
                start = mid + 1;
            } else end = mid - 1;
        }
        return maxWidth;
    }

    public static void main(String[] args) {

    }

}
