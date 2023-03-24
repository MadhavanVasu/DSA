package Medium;

public class FindDuplicateNum {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while(i<n)
        {
            while (true) {
                if (nums[i] - 1 != i) {
                    int temp = nums[nums[i] - 1];
                    if(nums[nums[i] - 1]==nums[i])
                        return nums[i];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;
                }
                else {
                    i++;
                    break;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,4,5,6,1};
        System.out.println(findDuplicate(nums));

    }
}
