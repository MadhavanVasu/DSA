package LeetCode.Hard;

import java.util.Arrays;

public class PermutationSequence {

    public static void reverseArray(int[] arr, int start, int end) {
        int length = end - start + 1;
        for (int i = 0; i < length / 2; i++) {
            int temp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i] = temp;
        }
    }

    public static void nextPermutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0) {
            if (arr[i - 1] < arr[i])
                break;
            i--;
        }
        if (i == 0)
            reverseArray(arr, 0,n-1);
        else {
            int j = n - 1;
            while (j != i - 1) {
                if (arr[j] > arr[i - 1])
                    break;
                j--;
            }
            int temp = arr[i - 1];
            arr[i - 1] = arr[j];
            arr[j] = temp;
            reverseArray(arr, i,n-1);
        }
    }

    public static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++)
            arr[i - 1] = i;
        int i = 0;
        while(i<k-1) {
            System.out.println(Arrays.toString(arr));
            nextPermutation(arr, n);
            i++;
        }
        String result = "";
        for(int x : arr)
            result = result.concat(Integer.toString(x));
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        System.out.println(getPermutation(n,k));
    }


}
