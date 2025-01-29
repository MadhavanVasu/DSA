package LeetCode.Easy;

public class CountPartitionsWithEvenSumDifference {

    public int countPartitions(int[] nums) {
        int rightSum = 0;
        for (int x : nums) rightSum += x;
        int leftSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (Math.abs(leftSum - rightSum) % 2 == 0) result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
