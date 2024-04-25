package LeetCode.Contest.Weekly392;

public class LongestStrictlyIncreasingOrDecreasingSubarray {

    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int incOrDec = 0;
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (incOrDec == 0 || incOrDec == -1) {
                    if (len > result) result = len;
                    incOrDec = 1;
                    len = 2;
                } else len++;
            } else if (nums[i] < nums[i - 1]) {
                if (incOrDec == 0 || incOrDec == 1) {
                    if (len > result) result = len;
                    len = 2;
                    incOrDec = -1;
                } else len++;
            }
        }
        if (len > result) result = len;
        return result;
    }

    public static void main(String[] args) {

    }

}
