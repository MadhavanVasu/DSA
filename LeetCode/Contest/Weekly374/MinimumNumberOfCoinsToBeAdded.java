package LeetCode.Contest.Weekly374;

import java.util.Arrays;

public class MinimumNumberOfCoinsToBeAdded {

    public int minimumAddedCoins(int[] coins, int target) {

        Arrays.sort(coins);
        int prefixSum = 0;
        int next = 1;
        int i = 0;
        int ans = 0;
        while (next <= target) {
            if (i < coins.length && coins[i] <= next) {
                prefixSum += coins[i++];
            } else if (prefixSum < next) {
                prefixSum += next;
                ans++;
            }
            next++;
        }
        return ans;

    }

    public static void main(String[] args) {

    }

}
