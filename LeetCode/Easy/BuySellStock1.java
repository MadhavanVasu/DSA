package Easy;

public class BuySellStock1 {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int max = prices[n-1];
        int i = n-2;
        while(i>=0)
        {
            int diff = max - prices[i];
            if(diff>profit)
                profit = diff;
            if(prices[i]>max)
                max = prices[i];
            i--;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {5};
        System.out.println(maxProfit(prices));
    }
}
