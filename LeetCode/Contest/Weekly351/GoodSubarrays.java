package LeetCode.Contest.Weekly351;

public class GoodSubarrays {

    public int numberOfGoodSubarraySplits(int[] nums) {

        long result = 1;
        int prev = -1;
        int curr = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev == -1) {
                    prev = i;
                } else if (curr == -1) {
                    curr = i;
                } else {
                    result = (result * (curr - prev)) % 1000000007;
                    prev = curr;
                    curr = i;
                }
            }
        }
        if (prev == -1)
            result = 0;
        if (curr != -1)
            result = (result * (curr - prev)) % 1000000007;
        return (int)result;

    }

    public static void main(String[] args) {

    }

}
