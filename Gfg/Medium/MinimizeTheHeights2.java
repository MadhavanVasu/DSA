package Gfg.Medium;

import java.util.Arrays;

public class MinimizeTheHeights2 {

    int getMinDiff(int[] arr, int n, int k) {
        int min = 0;
        int max = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] += k;
                min = arr[i];
                max = arr[i];
            } else {
                if (arr[i] - k < min) {
                    if (arr[i] - k >= 0) {
                        int tempMax = Math.max(max, arr[i] + k);
                        if (max - (arr[i] - k) < (tempMax - min)) arr[i] -= k;
                        else arr[i] += k;
                    } else arr[i] += k;
                } else arr[i] -= k;
                if (arr[i] > max) max = arr[i];
                if (arr[i] < min) min = arr[i];
            }
        }
        return max - min;
    }

    public static void main(String[] args) {

    }

}
