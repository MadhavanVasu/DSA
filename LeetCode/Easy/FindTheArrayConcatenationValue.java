package LeetCode.Easy;

public class FindTheArrayConcatenationValue {

    public long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            String concatStr = String.valueOf(nums[i]) + String.valueOf(nums[n - i - 1]);
            sum += Long.parseLong(concatStr);
        }
        return n % 2 == 0 ? sum : sum + nums[n / 2];
    }

    public static void main(String[] args) {

    }

}
