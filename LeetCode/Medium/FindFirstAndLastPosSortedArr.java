package LeetCode.Medium;

import java.util.Arrays;

public class FindFirstAndLastPosSortedArr {

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static int[] searchRange2(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int[] result = {-1, -1};
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                end = mid - 1;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                result[1] = mid;
                start = mid + 1;
            } else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return new int[]{-1, -1};
        int[] result = {-1, -1};
        int pos = binarySearch(nums, target, 0, n - 1);
        if (pos == -1)
            return result;
        result[0] = pos;
        result[1] = pos;
        int low = pos;
        do {
            low = binarySearch(nums, target, 0, low - 1);
            result[0] = low == -1 ? result[0] : low;
        } while (low != -1);
        int high = pos;
        do {
            high = binarySearch(nums, target, high + 1, n - 1);
            result[1] = high == -1 ? result[1] : high;
        } while (high != -1);
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 4, 8, 8, 8, 8};

        System.out.println(Arrays.toString(searchRange2(nums, 8)));

    }

}
