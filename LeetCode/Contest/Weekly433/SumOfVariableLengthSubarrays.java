package LeetCode.Contest.Weekly433;

public class SumOfVariableLengthSubarrays {

    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            result += prefixSum[i] - (start == 0 ? 0 : prefixSum[start - 1]);
        }
        return result;
    }

}

