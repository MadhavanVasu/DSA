package LeetCode.Easy;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefixSum = 0;
        int sum = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (sum - nums[i] == 0)
                    return i;
            } else if (i == n - 1) {
                if (prefixSum == 0)
                    return i;
            } else {
                if (prefixSum == sum - prefixSum - nums[i])
                    return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
