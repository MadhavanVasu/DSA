package LeetCode.Easy;

public class DetermineWinnerOfBowlingGame {

    public int isWinner(int[] player1, int[] player2) {

        int score1 = 0;
        int score2 = 0;
        int prev1 = Integer.MIN_VALUE;
        int prev2 = Integer.MIN_VALUE;
        for (int i = 0; i < player1.length; i++) {
            if (prev1 == i - 1 || prev1 == i - 2) score1 += (player1[i] * 2);
            else score1 += player1[i];
            if (prev2 == i - 1 || prev2 == i - 2) score2 += (player2[i] * 2);
            else score2 += player2[i];
            if (player1[i] == 10) prev1 = i;
            if (player2[i] == 10) prev2 = i;
        }
        return score1 > score2 ? 1 : score1 < score2 ? 2 : 0;

    }


    public static void main(String[] args) {
        int[] player1 = {4, 10, 7, 9};
        int[] player2 = {6, 5, 2, 3};

    }
}
