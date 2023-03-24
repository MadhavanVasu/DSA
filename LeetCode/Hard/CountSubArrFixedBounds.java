package LeetCode.Hard;

public class CountSubArrFixedBounds {

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int start = -1;
        int n = nums.length;
        long count = 0;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= maxK && nums[i] >= minK) {
                if (start == -1)
                    start = i;
                if (nums[i] == minK)
                    minIndex = i;
                if (nums[i] == maxK)
                    maxIndex = i;
                int min = Math.min(minIndex, maxIndex);
                if (min != -1)
                    count += min - start + 1;

            } else {
                start = -1;
                minIndex = -1;
                maxIndex = -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 4, 5, 4, 5};
        int minK = 1;
        int maxK = 5;
        System.out.println(countSubarrays(nums, minK, maxK));
    }

}
