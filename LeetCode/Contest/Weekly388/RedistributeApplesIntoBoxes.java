package LeetCode.Contest.Weekly388;

import java.util.Arrays;

public class RedistributeApplesIntoBoxes {

    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApplesLeft = 0;
        for (int x : apple) totalApplesLeft += x;
        int n = capacity.length;
        Arrays.sort(capacity);
        for (int i = n - 1; i >= 0; i--) {
            totalApplesLeft -= capacity[i];
            if (totalApplesLeft <= 0) return n - i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
