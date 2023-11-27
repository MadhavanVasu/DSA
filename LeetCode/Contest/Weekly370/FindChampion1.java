package LeetCode.Contest.Weekly370;

public class FindChampion1 {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (grid[i][j] != 1) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag == true) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
