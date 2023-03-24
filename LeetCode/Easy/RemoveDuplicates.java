package LeetCode.Easy;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int pos = 1;
        int prev = 0;
        int n = nums.length;
        for(int i=1; i<n; i++)
        {
            if(nums[i]!=nums[prev])
            {
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                prev = pos++;
            }
        }
        return pos;

    }

    public static void main(String[] args) {

    }

}
