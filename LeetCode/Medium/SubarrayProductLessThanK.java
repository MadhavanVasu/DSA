package LeetCode.Medium;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int start = -1;
        int i = 0;
        int n = nums.length;
        int result = 0;
        while (i < n) {
            if (nums[i] * product < k) {
                product *= nums[i];
                if (start == -1) start = i;
            } else if (start != -1) {
                int j = start;
                while (j != i) {
                    product /= nums[j];
                    if (product * nums[i] < k) break;
                    j++;
                }
                if (j == i) {
                    int len1 = j - start;
                    result += ((len1 * (len1 + 1)) / 2);
                } else {
                    int len1 = j - start + 1;
                    result += ((len1 * (len1 + 1)) / 2);
                    int len2 = i - (j + 1);
                    result += (len1 * len2);
                }
                if (product * nums[i] >= k) start = -1;
                else {
                    product *= nums[i];
                    start = j + 1;
                }
            }
            i++;
        }
        if (start != -1) result += ((i - start) * (i - start + 1)) / 2;
        return result;
    }

    public static void main(String[] args) {

    }

}
