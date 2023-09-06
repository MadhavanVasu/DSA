package LeetCode.Medium;

public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[end] && nums[mid]==nums[start]) {
                start++;
                end--;
            }
            else if(nums[end]>=target) start = mid+1;
            else end = start-1;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
