package LeetCode.Contest.Weekly411;

public class MaximumEnergyBoostFromTwoDrinks {

    public long helper(int i, int bottle, int n, int[] energyDrinkA, int[] energyDrinkB, Long[][] dp) {
        if (i == n) return 0;
        if (dp[i][bottle] != null) return dp[i][bottle];
        long a;
        long b;
        if (bottle == 0) {
            a = energyDrinkA[i] + helper(i + 1, 0, n, energyDrinkA, energyDrinkB, dp);
            b = helper(i + 1, 1, n, energyDrinkA, energyDrinkB, dp);
        } else {
            a = energyDrinkB[i] + helper(i + 1, 1, n, energyDrinkA, energyDrinkB, dp);
            b = helper(i + 1, 0, n, energyDrinkA, energyDrinkB, dp);
        }
        dp[i][bottle] = Math.max(a, b);
        return dp[i][bottle];
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        Long[][] dp = new Long[n][2];
        long a = helper(0, 0, n, energyDrinkA, energyDrinkB, dp);
        long b = helper(0, 1, n, energyDrinkA, energyDrinkB, dp);
        return Math.max(a, b);
    }

    public static void main(String[] args) {

    }

}
