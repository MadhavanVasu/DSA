package LeetCode.Hard;

public class StudentAttendanceRecord2 {

    public int helper(int i, int n, int leavesLeft, int late, Integer[][][] dp) {
        if (i == n) return 1;
        if (dp[i][leavesLeft][late] != null) return dp[i][leavesLeft][late];
        int a = 0;
        int b = 0;
        int c = 0;
        if (leavesLeft > 0) a = helper(i + 1, n, leavesLeft - 1, late, dp);
        if (late > 0) b = helper(i + 1, n, leavesLeft, late - 1, dp);
        else c = helper(i + 1, n, leavesLeft, 2, dp);
        int d = helper(i + 1, n, leavesLeft, late, dp);
        dp[i][leavesLeft][late] = a + b + c + d;
        return a + b + c + d;
    }

    public int checkRecord(int n) {
        Integer[][][] dp = new Integer[n][2][3];
        return helper(0, n, 1, 2, dp);
    }

    public static void main(String[] args) {

    }

}
