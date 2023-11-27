package LeetCode.Medium;

public class WinnerOfArrayGame {

    public int getWinner(int[] arr, int k) {
        int winner = 0;
        int currK = k;
        for (int i = 1; i < arr.length; i++) {
            if (currK == 0) return arr[winner];
            if (arr[winner] > arr[i]) {
                currK--;
            } else {
                currK = k - 1;
                winner = i;
            }
        }
        return arr[winner];
    }

    public static void main(String[] args) {

    }
}
