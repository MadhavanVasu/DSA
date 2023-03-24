package LeetCode.Medium;

public class SingleElementSortArr {

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if((mid-1<0 || nums[mid-1]!=nums[mid]) && (mid+1>=n || nums[mid+1]!=nums[mid]))
                return nums[mid];
            else if((nums[mid-1]==nums[mid] && ((mid-1)%2!=0)) || (nums[mid-1]!=nums[mid] && ((mid)%2!=0))) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));

    }

}
