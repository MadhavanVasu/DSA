package LeetCode.Medium;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int j = piles.length - 2;
        int k = 0;
        int result = 0;
        while (k < j) {
            result += piles[j];
            j -= 2;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
