package LeetCode.Medium;

import java.util.Arrays;

public class MinimumCostToMakeArrayIdentical {

    public long minCost(int[] arr, int[] brr, long k) {
        if (Arrays.equals(arr, brr)) return 0;
        long cost = 0;
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        int[] tempBrr = Arrays.copyOf(brr, brr.length);
        Arrays.sort(arr);
        Arrays.sort(brr);
        for (int i = 0; i < arr.length; i++) {
            cost += (Math.abs(arr[i] - brr[i]));
        }
        long actualPositionCost = 0;
        for (int i = 0; i < arr.length; i++) actualPositionCost += Math.abs(tempArr[i] - tempBrr[i]);
        return Math.min(actualPositionCost, cost + k);
    }

    public static void main(String[] args) {

    }

}
