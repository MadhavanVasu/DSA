package LeetCode.Hard;

public class MinimumReplacementsToSortArray {

    public long minimumReplacement(int[] nums) {

        long ans = 0;
        int n = nums.length;
        int i = n - 2;
        int prev = nums[n - 1];
        while (i >= 0) {
            if (nums[i] < prev) {
                prev = nums[i];
            } else {
                int rem = nums[i] % prev;
                if (rem == 0) {
                    ans += nums[i] / prev - 1;
                } else {
                    ans += nums[i] / prev;
                    prev = (prev + rem) / 2;
                }
            }
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {7, 6, 15, 6, 11, 14, 10};
        System.out.println(new MinimumReplacementsToSortArray().minimumReplacement(nums));

    }

}
