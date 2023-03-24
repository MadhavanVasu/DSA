package LeetCode.Medium;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right)
        {
            int area = (right-left)*Math.min(height[right], height[left]);
            if(area>max)
                max = area;
            if(height[right]<height[left])
                right--;
            else if(height[right]>height[left])
                left++;
            else
            {
                left++;
                right--;
            }
        }
        return max;
    }


}
