package LeetCode.Contest.Weekly419;

public class CountTheNumberOfWinningSequence {

    final int MOD = 1000000007;

    public int pointDecider(char c1, char c2) {
        if (c1 == 'F') {
            if (c2 == 'W') return -1;
            if (c2 == 'E') return 1;
        }
        if (c1 == 'W') {
            if (c2 == 'F') return 1;
            if (c2 == 'E') return -1;
        }
        if (c1 == 'E') {
            if (c2 == 'W') return 1;
            if (c2 == 'F') return -1;
        }
        return 0;
    }

    public int helper(int i, int prev, int points, String s, Integer[][][] dp, char[] creatures, int n) {
        if (i == n) {
            if (points > 1000) return 1;
            return 0;
        }
        int possibleWays = 0;
        for (int x = 0; x < 3; x++) {
            if (prev == -1 || x != prev) {
                points += pointDecider(creatures[x], s.charAt(i));
                possibleWays = (possibleWays + helper(i + 1, x, points, s, dp, creatures, n)) % MOD;
            }
        }
        if (prev == -1) prev = 0;
        dp[i][points][prev] = possibleWays;
        return possibleWays;
    }

    public int countWinningSequences(String s) {
        int n = s.length();
        Integer[][][] dp = new Integer[n][2001][3];
        return helper(0, -1, 1000, s, dp, new char[]{'F', 'W', 'E'}, n);
    }

    public static void main(String[] args) {

    }

}
