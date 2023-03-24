package LeetCode.Medium;

public class BuyAndSellStock2 {

    public static int greedySoln(int[] prices)
    {
        int buy = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]>buy)
            {
                profit+=(prices[i] - buy);
                buy = prices[i];
            }
            else
                buy = prices[i];
        }
        return profit;
    }

    public static int helper(int i, int tradeDirection, int[] prices, int n, int[][] dp) {
        if (i == n)
            return 0;
        if (dp[i][tradeDirection] != -1)
            return dp[i][tradeDirection];

        int a = 0;
        int b = 0;
        if (tradeDirection == 0) {
            a = -prices[i] + helper(i + 1, 1, prices, n, dp);
            b = helper(i + 1, 0, prices, n, dp);
        } else {
            a = prices[i] + helper(i + 1, 0, prices, n, dp);
            b = helper(i + 1, 1, prices, n, dp);
        }
        dp[i][tradeDirection] = Math.max(a, b);
        return Math.max(a, b);
    }

    public static int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++)
                dp[i][j] = -1;
        }
        return helper(0, 0, prices, prices.length, dp);

    }

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        System.out.println(greedySoln(prices));

    }

}
