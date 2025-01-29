package LeetCode.Contest.Weekly427;

public class TransformedArray {

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int newIndex = (nums[i] + i) % n;
                result[i] = nums[newIndex];
            } else if (nums[i] < 0) {
                int count = Math.abs(nums[i]);
                int j = i;
                while (count > 0) {
                    if (j == 0) {
                        j = n - 1;
                        count -= 1;
                    } else if (j <= count) {
                        j = 0;
                        count -= j;
                    } else {
                        j -= count;
                        count = 0;
                    }
                }
            } else result[i] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
