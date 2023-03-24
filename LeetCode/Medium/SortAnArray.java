package LeetCode.Medium;

import java.util.Arrays;

public class SortAnArray {

    public static void merge(int left, int mid, int right, int[] nums) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];
        for (i = 0; i < temp.length; i++)
            nums[left++] = temp[i];
    }

    public static void mergeSort(int left, int right, int[] nums) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid, nums);
            mergeSort(mid + 1, right, nums);
            merge(left, mid, right, nums);
        }
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(0, nums.length - 1, nums);
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
