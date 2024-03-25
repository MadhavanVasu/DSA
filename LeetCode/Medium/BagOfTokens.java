package LeetCode.Medium;

import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int currCoins = 0;
        int maxResult = 0;
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i];
                currCoins++;
                i++;
            } else if (currCoins >= 1) {
                currCoins -= 1;
                power += tokens[j];
                j--;
            } else break;
            if (currCoins > maxResult) maxResult = currCoins;
        }
        return maxResult;
    }

    public static void main(String[] args) {

    }

}
