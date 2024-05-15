package LeetCode.Contest.Weekly365;

public class MaximumTripletValue2 {

    public long maximumTripletValue(int[] nums) {
        long maxValue = 0;
        long maxDiff = (long) nums[1] - nums[0];
        long maxNum = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            long value = nums[i] * maxDiff;
            maxValue = Math.max(value, maxValue);
            if (nums[i] < maxNum) {
                maxDiff = Math.max(maxNum - nums[i], maxDiff);
            } else if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {

    }

}
