package LeetCode.Easy;

public class SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1)
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
