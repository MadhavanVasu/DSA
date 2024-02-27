package LeetCode.Contest.Weekly384;

public class NoOfSubarraysThatMatchPattern1 {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int result = 0;
        int m = pattern.length;
        int n = nums.length;
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            int k = 0;
            for (int j = i; j < i + m; j++) {
                if (!((nums[j] > nums[j + 1] && pattern[k] == -1) ||
                        (nums[j] < nums[j + 1] && pattern[k] == 1) ||
                        (nums[j] == nums[j + 1] && pattern[k] == 0))) {
                    flag = false;
                    break;
                }
            }
            if (flag) result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
