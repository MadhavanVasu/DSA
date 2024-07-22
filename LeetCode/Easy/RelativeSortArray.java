package LeetCode.Easy;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countArr = new int[1001];
        for (int x : arr1) countArr[x]++;
        int[] result = new int[arr1.length];
        int i = 0;
        for (int x : arr2) {
            while (countArr[x] > 0) {
                result[i++] = x;
                countArr[x]--;
            }
        }
        int j = 0;
        while (j < 1001 && i < arr1.length) {
            while (countArr[j] > 0) {
                result[i++] = j;
                countArr[j]--;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
