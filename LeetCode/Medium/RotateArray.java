package LeetCode.Medium;

import java.util.Arrays;

public class RotateArray {

    public void rotateElementsEachCycle(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(k==0)
            return;
        int start = 0;
        int rotateCount = 0;
        int curr = 0;
        int numToBeRotated = nums[curr];
        while (rotateCount < n) {
            do {
                int temp = nums[(curr + k) % n];
                nums[(curr + k) % n] = numToBeRotated;
                numToBeRotated = temp;
                curr = (curr + k) % n;
                rotateCount++;
            } while (curr != start);
            start++;
            curr = start;
            numToBeRotated = nums[curr];
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        System.out.println("hi");
        int n = end - start + 1;
        System.out.println(n);
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    public static void rotate(int[] nums, int k) {

        int n = nums.length;
        k = k % n;
        if (k == 0)
            return;
        reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, 0, k - 1);
        System.out.println(Arrays.toString(nums));
        reverse(nums, k, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
