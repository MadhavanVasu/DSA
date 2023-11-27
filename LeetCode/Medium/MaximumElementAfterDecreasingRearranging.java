package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumElementAfterDecreasingRearranging {

    public int maximumElementAfterDecrementingAndRearrangingOptimal(int[] arr) {
        int n = arr.length;
        int[] counterArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] <= n) counterArr[arr[i]]++;
        }
        int j = 1;
        int i = 0;
        while (i < n) {
            if (counterArr[j] == 0) {
                j++;
            } else {
                counterArr[j]--;
                if (counterArr[j] == 0) j++;
            }
            i++;
        }
        return j;
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new MaximumElementAfterDecreasingRearranging().maximumElementAfterDecrementingAndRearrangingOptimal(arr));

    }

}
