package LeetCode.Easy;

public class SquaresOfSortedArray {
    public int[] sortedSquaresClean(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int[] result = new int[n];
        for (int k = n - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                result[k] = nums[i] * nums[i];
                i++;
            } else {
                result[k] = nums[j] * nums[j];
                j--;
            }
        }
        return result;
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i;
        for (i = 0; i < n; i++) if (nums[i] >= 0) break;
        int positivePos = i;
        int negativePos = i - 1;
        i = 0;
        int[] result = new int[n];
        while (positivePos < n && negativePos >= 0) {
            if (nums[positivePos] < Math.abs(nums[negativePos]))
                result[i++] = nums[positivePos] * nums[positivePos++];
            else
                result[i++] = nums[negativePos] * nums[negativePos--];
        }
        while (positivePos < n) result[i++] = nums[positivePos] * nums[positivePos++];
        while (negativePos >= 0) result[i++] = nums[negativePos] * nums[negativePos--];
        return result;
    }

    public static void main(String[] args) {

    }
}
