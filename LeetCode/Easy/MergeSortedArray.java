package Easy;

import java.util.Arrays;

public class MergeSortedArray {

    //O(m+n) solution
    public static void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2, if any
            nums1[finished--] = nums2[tail2--];
        }
    }

    //O(m*n) solution
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0)
            return;
        int p1 = 0;
        while(p1<m)
        {
            if(nums1[p1]>nums2[0])
            {
                int temp = nums1[p1];
                nums1[p1] = nums2[0];
                nums2[0] = temp;
                int i = 0;
                while(i<n-1)
                {
                    if(nums2[i]>nums2[i+1])
                    {
                        temp = nums2[i];
                        nums2[i] = nums2[i+1];
                        nums2[i+1] = temp;
                        i++;
                    }
                    else
                        break;
                }
            }
            p1++;
        }
        int i = 0;
        while(i<n){
            nums1[p1] = nums2[i];
            i++;
            p1++;
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));


    }
}
