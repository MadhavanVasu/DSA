package LeetCode.Contest.Biweekly129;

public class MakeASquareWithSameColour {

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            int wCount = 0;
            int bCount = 0;
            for (int j = 0; j < 2; j++) {
                if (grid[i][j] == 'B') bCount++;
                else wCount++;
                if (grid[i][j + 1] == 'B') bCount++;
                else wCount++;
                if (grid[i + 1][j] == 'B') bCount++;
                else wCount++;
                if (grid[i + 1][j + 1] == 'B') bCount++;
                else wCount++;
            }
            if (wCount == 4 || wCount == 3) return true;
            if (bCount == 4 || bCount == 3) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
