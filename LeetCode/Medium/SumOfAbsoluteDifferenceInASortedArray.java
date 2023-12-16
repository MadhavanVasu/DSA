package LeetCode.Medium;

public class SumOfAbsoluteDifferenceInASortedArray {

    public int[] getSumAbsoluteDifferencesOptimal(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int x : nums) right += (x - 1);
        int left = 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            left += (nums[i] - 1);
            int leftAbsoluteDifference = ((nums[i] - 1) * (i + 1)) - left;
            int rightAbsoluteDifference = (right - left) - ((nums[i] - 1) * (n - 1 - i));
            result[i] = leftAbsoluteDifference + rightAbsoluteDifference;
        }
        return result;
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (nums[i] - 1);
            prefixSum[i] = sum;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {

            int leftSum = ((nums[i] - 1) * (i + 1)) - (prefixSum[i]);
            int rightSum = (prefixSum[n - 1] - prefixSum[i]) - ((nums[i] - 1) * (n - 1 - i));
            result[i] = leftSum + rightSum;
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
