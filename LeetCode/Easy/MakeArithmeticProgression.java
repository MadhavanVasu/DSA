package LeetCode.Easy;

import java.util.Arrays;

public class MakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) return false;
        }
        return true;

    }

    public static void main(String[] args) {

    }

}
