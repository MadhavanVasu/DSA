package Medium;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i : nums)
        {
            if(i==0)
                red++;
            else if(i==1)
                white++;
            else
                blue++;
        }
        for(int i=0; i<nums.length; i++) {
            if (red != 0) {
                nums[i] = 0;
                red--;
            } else if (white != 0) {
                nums[i] = 1;
                white--;
            } else {
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
