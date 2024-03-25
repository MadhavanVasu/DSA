package LeetCode.Contest.Weekly388;

import java.util.Arrays;

public class MaximumHappinessOfSelectedChildren {

    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long result = 0;
        int reduced = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (happiness[i] - reduced < 0 || k <= 0) break;
            result += (happiness[i] - reduced);
            reduced++;
            k--;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
