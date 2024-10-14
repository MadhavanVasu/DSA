package LeetCode.Medium;

public class FillingBookShelves {

    public int helper(int i, int remWidth, int fullWidth, int[][] books, int n, int maxHt, Integer[][] dp) {
        if (i == n - 1) {
            if (remWidth >= books[i][0]) return books[i][1] > maxHt ? books[i][1] : maxHt;
            return maxHt + books[i][1];
        }
        if (dp[i][remWidth] != null) return dp[i][remWidth];
        int a = Integer.MAX_VALUE;
        if (remWidth >= books[i][0]) {
            if (books[i][1] > maxHt)
                a = helper(i + 1, remWidth - books[i][0], fullWidth, books, n, books[i][1], dp);
            else a = helper(i + 1, remWidth - books[i][0], fullWidth, books, n, maxHt, dp);
        }
        int b = maxHt + helper(i + 1, remWidth, fullWidth, books, n, 0, dp);
        dp[i][remWidth] = Math.min(a, b);
        return dp[i][remWidth];
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        Integer[][] dp = new Integer[n][shelfWidth + 1];
        return helper(0, shelfWidth, shelfWidth, books, n, 0, dp);
    }

    public static void main(String[] args) {

    }

}
