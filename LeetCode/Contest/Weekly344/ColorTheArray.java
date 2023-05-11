package LeetCode.Contest.Weekly344;

public class ColorTheArray {

    public int[] colorTheArray(int n, int[][] queries) {

        int[] arr = new int[n];
        int adjColors = 0;
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            if (arr[index] != color) {
                if (index - 1 >= 0 && arr[index - 1] == arr[index] && arr[index]!=0) adjColors--;
                if (index + 1 < n && arr[index + 1] == arr[index] && arr[index]!=0) adjColors--;
                arr[index] = color;
                if (index - 1 >= 0 && arr[index - 1] == color) adjColors++;
                if (index + 1 < n && arr[index + 1] == color) adjColors++;
            }
            result[i] = adjColors;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
