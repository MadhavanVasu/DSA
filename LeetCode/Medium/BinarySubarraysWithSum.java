package LeetCode.Medium;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        if (goal == 0) {
            int start = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    if (start != -1) result += ((i - start) * ((i - start) + 1)) / 2;
                    start = -1;
                } else if (start == -1) start = 1;
            }
            return result;
        }
        int start = 0;
        int oneStart = -1;
        int oneEnd = -1;
        int sum = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == 1 && sum <= goal) {
                if (oneStart == -1) oneStart = i;
                oneEnd = i;

            } else if (sum > goal) {
                result += ((oneStart - start + 1) * (i - oneEnd));
                start = oneStart + 1;
                oneStart = start;
                oneEnd = i;
                sum -= 1;
                while (nums[oneStart] != 1) oneStart++;
            }
        }
        if (sum == goal) result += ((oneStart - start + 1) * (i - oneEnd));
        return result;
    }

    public static void main(String[] args) {

    }

}
