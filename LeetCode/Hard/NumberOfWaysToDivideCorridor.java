package LeetCode.Hard;

public class NumberOfWaysToDivideCorridor {
    int MOD = 1000000007;

    public int numberOfWaysOptimal(String corridor) {
        int result = 0;
        int n = corridor.length();
        int plants = 0;
        int seats = 0;
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') seats++;
            else {
                if (seats <= 2)
                    plants++;
            }
            if (seats % 2 == 0) {
                result = result == 0 ? plants + 1 : (result * (plants + 1)) % MOD;
                seats = 0;
                plants = 0;
            }
        }
        if (seats != 0) return 0;
        return result;
    }

    public int helper(int i, int chairCount, String corridor, int n, Integer[][] dp) {
        if (i >= n) {
            if (chairCount == 2) return 1;
            return 0;
        }
        if (dp[i][chairCount] != null) return dp[i][chairCount];
        int ans = 0;
        if (corridor.charAt(i) == 'S') {
            if (chairCount != 2) {
                int a = helper(i + 1, chairCount + 1, corridor, n, dp);
                ans = (ans + a) % MOD;
                if (chairCount + 1 == 2) {
                    int b = helper(i + 1, 0, corridor, n, dp);
                    ans = ((ans + b) % MOD) % MOD;
                }
            }
        } else {
            int a = helper(i + 1, chairCount, corridor, n, dp);
            ans = (ans + a) % MOD;
            if (chairCount == 2) {
                int b = helper(i + 1, 0, corridor, n, dp);
                ans = ((ans + b) % MOD) % MOD;
            }
        }
        dp[i][chairCount] = ans;
        return ans;
    }

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        Integer[][] dp = new Integer[n][3];
        int count = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') count++;
        }
        if (count == 0 || count % 2 != 0) return 0;
        return helper(0, 0, corridor, n, dp);
    }

    public static void main(String[] args) {

    }

}
