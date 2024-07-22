package LeetCode.Contest.Weekly404;

public class FindTheMaximumLengthOfValidSubsequence1 {

    public int maximumLength(int[] nums) {
        int currLen = 0;
        int odd = 0;
        int even = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                next = nums[i] % 2;
            }
            if (nums[i] % 2 == next) {
                next = nums[i] % 2 == 0 ? 1 : 0;
                currLen++;
            }
            if (nums[i] % 2 == 0) even++;
            else odd++;
        }
        return Math.max(currLen, Math.max(odd, even));
    }

    public static void main(String[] args) {

    }

}
