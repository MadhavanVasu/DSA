package LeetCode.Medium;

public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = -1;
        long sum = 0;
        if (2 * k + 1 > n) return result;
        for (int i = 0; i < 2 * k + 1; i++) sum += nums[i];
        result[k] = (int) (sum / (2 * k + 1));
        for (int i = k + 1; i < n - k; i++) {
            sum -= nums[i - k - 1];
            sum += nums[i + k];
            result[i] = (int) (sum / (2 * k + 1));
        }
        return result;

    }

    public static void main(String[] args) {


    }

}
